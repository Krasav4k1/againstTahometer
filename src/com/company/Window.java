package com.company;
import javax.swing.*;
public class Window extends JFrame{

     Window(){
         super("UnTahometer");
         Panel panel= new Panel();
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setContentPane(panel);
         pack();
         setLocationRelativeTo(null);
         panel.start();
     }
}
