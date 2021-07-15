import java.util.*;

public class Homework14 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] initial = new int[3];
		System.out.println("======猜拳游戏开始=======");
		Mora mo = new Mora();
		System.out.println("是否想开始游戏：1 开始 0 结束");
		int isPlay = in.nextInt();
		while(isPlay == 1) {
			System.out.println("请输入你想出的拳：0 石头 1 剪刀 2 布");
			int yourMora = in.nextInt();
			mo.generateMora();
			System.out.println("你的拳：" + yourMora + " 电脑出拳：" + mo.mora);
			initial = mo.playMora(yourMora, initial);
			System.out.println("是否想继续游戏：1 开始 0 结束");
			isPlay = in.nextInt();
		}
		System.out.println("=======游戏结束！=======");
		System.out.println("【战况】输" + initial[0] + "次 平局" + 
			initial[1] + "次 赢" + initial[2] +"次");
	}
}

/**
 * 有个人Tom设计他的成员变量.成员方法，可以电脑猜拳。
 * 电脑每次都会随机生成0，1，2。0表示石头，1表示剪刀，
 * 2表示布，并要可以显示Tom的输赢次数（清单）。
*/
class Mora { // 猜拳
	int mora; // 表示出的是哪一个，0表示石头，1表示剪刀，2表示布

	public void generateMora() {
		// 生成随机数 0~2
		mora = (int)(Math.random() * 3);
	}

	// 进行猜拳,最后返回你是否猜拳胜利,1表示胜利，0表示平局，-1表示输
	// initial表示之前的战况
	public int[] playMora(int yourMora, int[] initial) {
		int[] res = initial; // res[0] 记录输的局数，res[1] 平局数， res[2] 赢
		if((yourMora == 0 && mora == 2) || (yourMora == 1 && mora == 0)
			|| (yourMora == 2 && mora == 1)) {
			System.out.println("恭喜你赢了！");
			res[2]++;
		}
		else if(yourMora == mora) {
			System.out.println("是平局！");
			res[1]++;
		} else {
			System.out.println("好可惜，你输了！呜呜呜~~~");
			res[0]++;
		}
		return res;
	}
}