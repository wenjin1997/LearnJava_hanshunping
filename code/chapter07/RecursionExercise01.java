public class RecursionExercise01 {
	public static void main(String[] args) {
		T t1 = new T();
		
		// // 斐波那契数
		// int n = 7;
		// int res = t1.fibonacci(n);
		// if (n != -1) {
		// 	System.out.println("当n=" + n + "时，斐波那契数为：" + res);
		// }


		// 猴子吃桃子问题
		int day = 8;
		int peachNum = t1.peach(day);
		if (peachNum != -1) {
			System.out.println("第" + day + "天时，有" + peachNum + "个桃子");
		}


	}
}

class T {
	// 求斐波那契数
	public int fibonacci(int n) {
		if (n >= 1) {
			if (n == 1 || n == 2) {
				return 1;
			} else {
				return fibonacci(n - 1) + fibonacci(n - 2);
			}
		} else {
			System.out.println("请输入大于等于1的数");
			return -1;
		}
	}

	// 猴子吃桃子问题
	/*
	猴子吃桃子问题:有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个! 
	以后每天猴子都吃其中的一半，然后再多吃一个。当到第 10 天时， 
	想再吃时(即还没吃)，发现只有 1 个桃子了。问题:最初共多少个桃子?
	
	思路分析：
	1. day = 10, peachNum(10) = 1;
	2. day = 9, peachNum(9) = (peachNum(10) + 1) * 2 = 4;
	递推公式：peachNum (day) = (peachNum(day + 1) + 1) * 2
	*/
	public int peach(int day) {
		if (day == 10) {
			return 1;
		} else if (day >= 1 && day <= 9) {
			return (peach(day + 1) + 1) * 2;
		} else {
			System.out.println("day需要在1-10！");
			return -1;
		}
	}
}