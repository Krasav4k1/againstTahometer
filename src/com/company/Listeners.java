package com.company;

import java.awt.event.*;

public class Listeners implements KeyListener, MouseListener, MouseMotionListener {


    @Override
    public void keyPressed(KeyEvent e) {
        int key =  e.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            Panel.mouseText= "On";
            Panel.keyText= "On";
            Panel.pressKey = true;
            Panel.moveMouse = true;
        }
        if (key == KeyEvent.VK_ESCAPE) {
            Panel.pressKey = false;
            Panel.moveMouse = false;
            Panel.mouseText= "Of";
            Panel.keyText= "Of";
        }

        if (key == KeyEvent.VK_Q) {
            Panel.monitorOff = false;
            Panel.PreMonitorOff = false;
            Panel.pressKey = false;
            Panel.moveMouse = false;
            Panel.mouseText= "Of";
            Panel.keyText= "Of";
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            Panel.clicOnMenu = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            Panel.clicOnMenu = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    public void mouseDragged(MouseEvent e) {
        Panel.mouseX = e.getX();
        Panel.mouseY = e.getY();
    }


    public void mouseMoved(MouseEvent e) {
        Panel.mouseX = e.getX();
        Panel.mouseY = e.getY();
    }

}
