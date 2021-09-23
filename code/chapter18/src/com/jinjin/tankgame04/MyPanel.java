package com.jinjin.tankgame04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author 文进
 * @version 1.0
 * 坦克大战的绘图区域
 */
//由于要不断重绘子弹，因此要继承Runnable
public class MyPanel extends JPanel implements KeyListener,Runnable {
    //定义我的坦克
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;

    public MyPanel() {
        hero = new Hero(100, 100); //初始化自己坦克
        hero.setSpeed(2); //设置坦克的速度
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);

            //坦克的子弹
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.shots.add(shot);
            new Thread(shot).start();
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); //填充颜色，默认黑色

        //画出坦克-封装方法
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);

            //画出敌人坦克的子弹
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                //取出敌人的子弹
                Shot shot = enemyTank.shots.get(j);
                if (shot.isLive) {
                    g.fillOval(shot.x, shot.y, 2,2);
                } else {
                    enemyTank.shots.remove(shot);
                }
            }
        }

        //画出子弹
        if (hero.shot != null && hero.shot.isLive == true) {
            g.fillOval(hero.shot.x, hero.shot.y, 2,2);
        }
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
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            hero.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            hero.shotEnemy();
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           repaint();
        }
    }
}
