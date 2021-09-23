package com.jinjin.tankgame04;

import java.util.Vector;

/**
 * @author 文进
 * @version 1.0
 * 敌人的坦克
 */
public class EnemyTank extends Tank {
    public Vector<Shot> shots = new Vector<>();
    public EnemyTank(int x, int y) {
        super(x, y);
    }
}
