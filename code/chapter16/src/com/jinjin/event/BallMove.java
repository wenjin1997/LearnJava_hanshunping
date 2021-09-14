package com.jinjin.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author 文进
 * @version 1.0
 * 小球通过键盘控制上下左右移动 -> Java的事件控制
 */
public class BallMove extends JFrame {
    private MyPanel mp = null;

    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel implements KeyListener {
    int x = 10; //小球左上角的横坐标
    int y = 10; //小球左上角的纵坐标

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.pink);
        g.fillOval(x, y, 30, 30);
    }


    //有字符输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //当某个键按下，该方法会触发
    @Override
    public void keyPressed(KeyEvent e) {
        int change = 5;
        //根据用户按下的不同键，来处理小球的移动(上下左右)
        //在java中，会给每一个键，分配一个值(int)
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y += change;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y -= change;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x -= change;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x += change;
        }
        repaint();
    }

    //当某个键释放，该方法会触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
