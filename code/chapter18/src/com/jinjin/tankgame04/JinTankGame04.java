package com.jinjin.tankgame04;

import javax.swing.*;

/**
 * @author 文进
 * @version 1.0
 */
public class JinTankGame04 extends JFrame {
    //定义MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {
        JinTankGame04 jinTankGame01 = new JinTankGame04();
    }

    public JinTankGame04() {
        mp = new MyPanel();
        this.add(mp); //添加面板(就是游戏的绘图区域)
        Thread thread = new Thread(mp);
        thread.start();
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
