public class Homework11 {
	public static void main(String[] args) {
		
	}
}

/*
在测试方法中，调用method方法，代码如下，编译正确，
试写出method方法的定义形式，
调用语句为：`System.out.println(method(method(10.0,20.0),100));`。
*/
class Test {
	public double method(double d1, double d2) {
		return d1;

	}
	public void test() {
		System.out.println(method(method(10.0,20.0),100));
	}
}
