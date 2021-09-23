package com.jinjin.tankgame04;

/**
 * @author 文进
 * @version 1.0
 * 自己的坦克
 */
public class Hero extends Tank {
    Shot shot = null;
    public Hero(int x, int y) {
        super(x, y);
    }

    public void shotEnemy(){
        switch (this.getDirect()) {
            case 0: //坦克的方向，向上
                shot = new Shot(this.getX() + 20, this.getY(), 0);
                break;
            case 1: //向右
                shot = new Shot(this.getX() + 60, this.getY() + 20, 1);
                break;
            case 2: //向下
                shot = new Shot(this.getX() + 20, this.getY() + 60, 2);
                break;
            case 3: //向左
                shot = new Shot(this.getX(), this.getY() + 20, 3);
                break;
        }
        new Thread(shot).start();
    }
}
