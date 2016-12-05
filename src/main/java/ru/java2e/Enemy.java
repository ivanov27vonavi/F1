package ru.java2e;

import javax.swing.*;
import java.awt.*;


public class Enemy {

    int x;
    int y;
    int v;

    Image img = new ImageIcon("res/enemy.jpg").getImage();

    Road road;

    public Rectangle getRect(){
        return new Rectangle(x, y, 180, 84);
    }

    public Enemy(int x, int y, int v, Road road) {
        this.x = x;
        this.y = y;
        this.v = v;
        this.road = road;
    }

    public void move(){
        x = x - road.p.v + v;
    }


}
