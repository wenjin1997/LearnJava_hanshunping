package com.jinjin.tankgame04;

/**
 * @author 文进
 * @version 1.0
 * 子弹射击
 */
public class Shot implements Runnable{
    int x; //子弹的横坐标
    int y;
    int direction = 0; //子弹方向
    int speed = 4; //子弹速度
    boolean isLive = true;

    public Shot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direction) {
                case 0: //向上
                    y -= speed;
                    break;
                case 1: //向右
                    x += speed;
                    break;
                case 2: //向下
                    y += speed;
                    break;
                case 3: //向左
                    x -= speed;
                    break;
            }

            System.out.println("子弹 x=" + x + " y=" + y);
            //到达边缘，子弹销毁
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750)){
                isLive = false;
                break;
            }
        }
    }
}
