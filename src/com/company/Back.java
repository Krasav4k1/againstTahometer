package com.company;

import java.awt.*;

public class Back {

    //Fields
    private Color color;

    //Constructor
    public Back(){this.color = Color.BLACK;}

    //Function
    public void update(){

    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillRect(0,0, Panel.wigth, Panel.heigth);
    }
}
