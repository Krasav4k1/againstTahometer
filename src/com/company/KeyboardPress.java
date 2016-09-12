package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by devds on 08.09.16.
 */

public class KeyboardPress {

    public static void keyboard () throws AWTException, InterruptedException {
        final Integer[] count = {0};
        Thread thread = new Thread(){
            public void run(){
                while (true) {
                    try {
                        Robot robot = new Robot();
                        if (Panel.pressKey) {
                            if(Panel.PreMonitorOff){
                                Panel.monitorOff = true;
                            }

                            count[0]++;

                            System.out.println(count[0]);
                            System.out.println((count[0] % 2) == 0);

                            if((count[0] % 2) == 0){
                                robot.keyPress(KeyEvent.VK_CONTROL);
                                robot.keyPress(KeyEvent.VK_TAB);

                                robot.keyRelease(KeyEvent.VK_TAB);
                                robot.keyRelease(KeyEvent.VK_CONTROL);
                            }else {
                                robot.keyPress(KeyEvent.VK_ALT);
                                robot.keyPress(KeyEvent.VK_TAB);
                                Thread.sleep((long) (Math.random() * 100 + 600));
                                robot.keyRelease(KeyEvent.VK_TAB);
                                robot.keyRelease(KeyEvent.VK_ALT);
                            }


                            robot.keyPress(KeyEvent.VK_UP);
                            robot.keyRelease(KeyEvent.VK_UP);
                            robot.keyPress(KeyEvent.VK_DOWN);
                            robot.keyRelease(KeyEvent.VK_DOWN);

                            robot.keyPress(KeyEvent.VK_LEFT);
                            robot.keyRelease(KeyEvent.VK_LEFT);
                            robot.keyPress(KeyEvent.VK_RIGHT);
                            robot.keyRelease(KeyEvent.VK_RIGHT);


                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    } catch (AWTException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (Panel.mouseX > Panel.wigth / 5 - 200 / 5
                            && Panel.mouseX < Panel.wigth / 5 + 800 / 5
                            && Panel.mouseY > Panel.heigth / 2 - 100 / 2
                            && Panel.mouseY < Panel.heigth / 2 + 100 / 2) {
                        if (Panel.clicOnMenu && Panel.keyText.equals("Of")) {
                            Panel.pressKey = true;
                            Panel.keyText = "On";
                        }
                    }

                    if (Panel.mouseX > Panel.wigth / 2
                            && Panel.mouseX < Panel.wigth / 2 + 20
                            && Panel.mouseY > Panel.heigth / 2 + 100
                            && Panel.mouseY < Panel.heigth / 2 + 120) {
                        if(Panel.clicOnMenu){
                            Panel.PreMonitorOff = true;
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
        g.drawRect(Panel.wigth / 2,
                Panel.heigth / 2 + 100 ,
                20, 20);
        if (Panel.PreMonitorOff){
            g.setColor(Color.RED);
            g.fillRect(Panel.wigth / 2, Panel.heigth / 2 + 100, 20, 20);
        }


        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(3));
        g.drawRect(Panel.wigth / 5 - 200 / 5,
                Panel.heigth / 2 - 100 / 2,
                200, 100);


        g.setColor(Color.WHITE);
        g.setFont(new Font("Consoles", Font.BOLD, 40));
        long length0 = (int) g.getFontMetrics().getStringBounds("Keyboard", g).getWidth();
        g.drawString("Keyboard", (int) Panel.wigth / 2 - length0 - 10, (int) Panel.heigth / 2 - 100);



        g.setColor(Color.WHITE);
        g.setFont(new Font("Consoles", Font.BOLD, 40));
        long length = (int) g.getFontMetrics().getStringBounds(Panel.keyText, g).getWidth();
        g.drawString(Panel.keyText, (int) Panel.wigth / 3 - length + 5, (int) Panel.heigth / 2 + 90 / 5);
    }

}
