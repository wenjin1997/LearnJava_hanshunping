package com.jinjin.tankgame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author 文进
 * @version 1.0
 * 坦克大战的绘图区域
 */
public class MyPanel extends JPanel implements KeyListener {
    //定义我的坦克
    Hero hero = null;
    int type = 1;

    public MyPanel() {
        hero = new Hero(100, 100); //初始化自己坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); //填充颜色，默认黑色

        //画出坦克-封装方法
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), type);
    }

    /**
     * @param x      坦克的左上角x坐标
     * @param y      坦克的左上角y坐标
     * @param g      画笔
     * @param direct 坦克方向(上下左右)
     * @param type   坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        //根据不同类型的坦克，设置不同的颜色
        switch (type) {
            case 0: //敌人的坦克
                g.setColor(Color.cyan);
                break;
            case 1: //我们的坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克方向，来绘制坦克
        //0:向上 1：向右 2：向下 3:向左
        switch (direct) {
            case 0: //表示向上
                g.fill3DRect(x, y, 10, 60, false); //左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false); //右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false); //坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20); //圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y); //画出炮筒
                break;
            case 1:
                g.fill3DRect(x, y, 60, 10, false); //左边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false); //右边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false); //坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20); //圆形盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20); //画出炮筒
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false); //左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false); //右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false); //坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20); //圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60); //画出炮筒
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10, false); //左边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false); //右边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false); //坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20); //圆形盖子
                g.drawLine(x + 30, y + 20, x, y + 20); //画出炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirect(0);
            hero.setY(hero.getY() - 1);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            hero.setX(hero.getX() + 1);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            hero.setY(hero.getY() + 1);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            hero.setX(hero.getX() - 1);
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
