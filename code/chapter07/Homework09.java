public class Homework09 {
	public static void main(String[] args) {
		Time t1 = new Time(0, 3, 33);
		Music m1 = new Music("拖延症", t1);
		m1.play();
		m1.getInfo();
	
	}
}

/*
定义Music类，里面有音乐名name、
音乐时长times属性，并有播放play功能和返回本身属性信息的功能getInfo.
*/
class Music {
	String name;
	Time times;

	public Music(String name, Time times) {
		this.name = name;
		this.times = times;
	}

	public void play() {
		System.out.println("正在播放歌曲" + this.name);
	}

	public void getInfo() {
		System.out.println("歌曲信息 歌曲名 " + this.name + " 音乐时长 " + times.hour + ":" +
			times.mins + ":" + times.secs);
	}
}

class Time {
	// 表示时间的类，有小时，分钟，秒
	int hour;
	int mins;
	int secs;

	public Time(int hour, int mins, int secs) {
		this.hour = hour;
		this.mins = mins;
		this.secs = secs;
	}
	Time() {

	}
}