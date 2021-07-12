public class Recursion01 {
	public static void main(String[] args) {
		T t1 = new T();
		t1.test(4);
		int res = t1.factorial(5);
		System.out.println("5的阶乘为：" + res);
	}
}

class T {
	// 递归方法test
	public void test(int n) {
		if (n > 2) {
			test(n - 1);
		}
		System.out.println("n = " + n);
	}

	// 递归方法 阶乘
	public int factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return factorial(n  - 1) * n;
		}
	}
}