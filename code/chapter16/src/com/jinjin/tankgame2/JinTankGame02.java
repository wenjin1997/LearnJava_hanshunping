package com.jinjin.tankgame2;

import javax.swing.*;

/**
 * @author 文进
 * @version 1.0
 */
public class JinTankGame02 extends JFrame {
    //定义MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {
        JinTankGame02 jinTankGame01 = new JinTankGame02();
    }

    public JinTankGame02() {
        mp = new MyPanel();
        this.add(mp); //添加面板(就是游戏的绘图区域)
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
