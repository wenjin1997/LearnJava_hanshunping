public class Homework04 {
	public static void main(String[] args) {
		A03 a = new A03();
		int[] arr = {1, 2, 21, 22, 11, 11};
		int[] copyarr = a.copyArr(arr);

		for(int i = 0; i < copyarr.length; i++) {
			System.out.print(copyarr[i]);
			System.out.print(" ");
		}

	}
}

/*
编写类A03,实现数组的复制功能copyArr，
输入旧数组，返回一个新数组，元素和旧数组一样。
*/
class A03 {
	public int[] copyArr(int[] arr) {
		int[] copyarr = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			copyarr[i] = arr[i];
		}
		return copyarr;
	}
}