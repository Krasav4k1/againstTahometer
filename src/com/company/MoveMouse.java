package com.company;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * Created by devds on 08.09.16.
 */

public class MoveMouse {



    public static void mouse () throws AWTException, InterruptedException {
        Thread thread = new Thread(){
            public void run() {

                while (true) {
                    PointerInfo a = MouseInfo.getPointerInfo();
                    Point b = a.getLocation();
                    if (Panel.moveMouse) {
                        if(Panel.PreMonitorOff){
                            Panel.monitorOff = true;
                        }

                        Double angle = Math.toRadians(Math.random() * 360);

                        Integer x = (int) b.getX();
                        Integer y = (int) b.getY();

                        Integer dx = (int) (Math.sin(angle) * Panel.speed);
                        Integer dy = (int) (Math.cos(angle) * Panel.speed);

                        x += dx;
                        y += dy;

                        if (x < 0 && dx < 0) dx = -dx;
                        if (x > Panel.width && dx > 0) dx = -dx;

                        if (y < 0 && dy < 0) dy = -dy;
                        if (y > Panel.height && dy > 0) dy = -dy;

//                        Panel.robot.mouseMove(x, y);

                        Panel.robot.mousePress( InputEvent.BUTTON1_MASK );
                        Panel.robot.mouseRelease( InputEvent.BUTTON1_MASK );

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                    if (Panel.mouseX > (Panel.wigth / 2) + 35
                            && Panel.mouseX < (Panel.wigth / 2) + 245
                            && Panel.mouseY > Panel.heigth / 2 - 100 / 2
                            && Panel.mouseY < Panel.heigth / 2 + 100 / 2) {
                        if (Panel.clicOnMenu && Panel.mouseText.equals("Of")) {
                            Panel.moveMouse = true;
                            Panel.mouseText = "On";
                        }
                    }
                }
            }
        };
        thread.start();
    }

    public void draw(Graphics2D g){

        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(3));
        g.drawRect(Panel.wigth / 2 + 200 / 5,
                Panel.heigth / 2 - 100 / 2,
                200, 100);



        g.setColor(Color.WHITE);
        g.setFont(new Font("Consoles", Font.BOLD, 40));
        long length2 = (int) g.getFontMetrics().getStringBounds(Panel.mouseText, g).getWidth();
        g.drawString(Panel.mouseText, (int) Panel.wigth / 2 + length2 + 60 , (int) Panel.heigth / 2 + 90 / 5);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Consoles", Font.BOLD, 40));
        long length3 = (int) g.getFontMetrics().getStringBounds("Mouse", g).getWidth();
        g.drawString("Mouse", (int) Panel.wigth / 2 + length3 - 85, (int) Panel.heigth / 2 - 100);

    }

}
