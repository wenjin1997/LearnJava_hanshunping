public class OverLoadExercise {
	public static void main(String[] args) {
		Methods method = new Methods();
		// 方法的重载
		method.m(5); //25
		method.m(5, 20); //100
		method.m("你好"); //你好

		System.out.println("最大的数是" + method.max(10.0, 20.2, 90.1));

	}
}

class Methods {
	public void m(int n) {
		System.out.println("平方=" + (n * n));
	}

	public void m(int n1, int n2) {
		System.out.println("相乘=" + (n1 * n2));
	}

	public void m(String str) {
		System.out.println("输入的字符串为：" + str);
	}

	// 返回两个int值中的最大值
	public int max(int n1, int n2) {
		return n1 > n2 ? n1 : n2; //三元运算符
	}

	public double max(double n1, double n2) {
		return n1 > n2 ? n1 : n2; //三元运算符
	}

	public double max(double n1, double n2, double n3) {
		double max1 = n1 > n2 ? n1 : n2;
		return max1 > n3 ? max1 : n3;
	}
}