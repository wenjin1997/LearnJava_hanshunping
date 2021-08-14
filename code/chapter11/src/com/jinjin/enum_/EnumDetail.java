package com.jinjin.enum_;

/**
 * @author 文进
 * @version 1.0
 */
public class EnumDetail {
    public static void main(String[] args) {
        Music.CLASSICMUSIC.play();
    }
}

class A {

}

//1.使用enum关键字后，就不能再继承其它类了，因为enum会隐式继承Enum，而Java是单继承机制
//enum Season3 extends A {
//
//}
//2.enum实现的枚举类，仍然是一个类，所以还是可以实现接口的.
interface IPlaying{
    void play();
}
enum Music implements IPlaying{
    CLASSICMUSIC;

    @Override
    public void play() {
        System.out.println("播放好听的音乐...");
    }
}
