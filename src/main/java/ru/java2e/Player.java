package ru.java2e;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    public static final int MAX_V = 100;
    public static final int MAX_TOP = 100;
    public static final int MAX_BOTTON = 350;


    Image img_c = new ImageIcon("res/player.jpg").getImage();
    Image img_l = new ImageIcon("res/player_left.jpg").getImage();
    Image img_r = new ImageIcon("res/player_right.jpg").getImage();

    Image img = img_c;




    public Rectangle getRect(){
        return new Rectangle(x, y, 180, 100);
    }

    int v = 0;
    int dv = 0;
    int s = 0;

    int x = 100;
    int y = 110;
    int dy = 0;

    int layer1 = 0;
    int layer2 = 1200;

    public void move(){
        s += v;
        v += dv;

        if (v <= 0 ){
            v = 0;
        }

        if(v >= MAX_V){
            v = MAX_V;
        }

        if(y <= MAX_TOP){
            y = MAX_TOP;
        }

        if(y >= MAX_BOTTON){
            y = MAX_BOTTON;
        }

        y -= dy;

        if(layer2 - v <= 0){
            layer1 = 0;
            layer2 = 1200;
        }
        layer1 -= v;
        layer2 -= v;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT){
            dv = 5;
        }
        if (key == KeyEvent.VK_LEFT) {
            dv = - 5;
        }
        if (key == KeyEvent.VK_UP) {
            dy = 10;
            img = img_l;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = - 10;
            img = img_r;
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT){
            dv = 0;
        }
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN){
            dv = 0;
            img  = img_c;
        }
    }
}
