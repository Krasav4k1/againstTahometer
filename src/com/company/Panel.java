package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Panel extends JPanel implements Runnable{

    public static int speed= 20;
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static double width = screenSize.getWidth();
    public static double height = screenSize.getHeight();
    public static boolean pressKey = false;
    public static boolean moveMouse = false;
    public static MoveMouse moveMouseObj;
    public static KeyboardPress keyboardPress;
    public static Back back;
    public static boolean clicOnMenu;
    private static Graphics2D g;
    private static BufferedImage image;
    public static String mouseText = "Of";
    public static String keyText = "Of";
    public static double mouseX;
    public static double mouseY;
    public static Robot robot;
    public static boolean monitorOff = false;
    public static boolean PreMonitorOff = false;

    public static int wigth = 600;
    public static int heigth = 600;

    private Thread thread;

    public Panel(){
        super();
        setPreferredSize(new Dimension(wigth,heigth));
        setFocusable(true);
        requestFocus();

        addKeyListener(new Listeners());
        addMouseMotionListener(new Listeners());
        addMouseListener(new Listeners());
    }


    public synchronized void start(){
        thread = new Thread(this);
        thread.setName("New New");
        thread.start();
    }

    @Override
    public void run() {
        image = new BufferedImage(wigth, heigth, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        back = new Back();
        keyboardPress = new KeyboardPress();
        moveMouseObj = new MoveMouse();
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        try {
            update();
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if(monitorOff)
                Runtime.getRuntime().exec("xset dpms force off");
                Thread.sleep(200);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            render();
            draw();
        }
    }

    public void update() throws AWTException, InterruptedException {
        moveMouseObj.mouse();
        keyboardPress.keyboard();
    }

    public static void render() {
        back.draw(g);
        keyboardPress.draw(g);
        moveMouseObj.draw(g);
    }

    public void draw(){
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }

}
