public class MethodExercise01 {
	public static void main(String[] args) {
		AA a1 = new AA();
		System.out.println("是奇数吗？" + a1.isOdd(3));
		a1.printRowAndCol(4, 4, '#');

	}
}

class AA {
	public boolean isOdd(int n) {
		// // 1.if-else 判断
		// if (n % 2 != 0) {
		// 	return true; // 如果是奇数，返回true
		// }
		// else {
		// 	return false; // 如果是偶数，返回false
		// }

		// // 2.三元运算符
		// return n % 2 != 0 ? true : false;

		// 3. 直接返回
		return n % 2 != 0;


	}

	public void printRowAndCol(int raw, int col, char c) {
		for (int i = 1; i <= raw; i++) {
			for (int j = 1; j <= col; j++) {
				System.out.print(c);
			}
			System.out.print("\n");
		}
	}

}