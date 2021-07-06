public class Method01 {

	// 编写一个main方法
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.speak();
		p1.cal01();
		p1.cal02(100);
		System.out.println("10+20=" + p1.getSum(10,20)); // 计算10+20
	}
}

class Person {
	String name;
	int age;

	// 方法（成员方法）
	public void speak() {
		System.out.println("我是一个好人");
	}

	// 添加 cal01 成员方法，可计算从1+...+1000的结果
	public void cal01() {
		int res = 0;
		for (int i = 1; i <= 1000; i++) {
			res += i;
		}
		System.out.println("方法cal01 计算结果=" + res);
	}

	// 添加 cal02 成员方法，可计算从1+...+n的结果
	public void cal02(int n) {
		int res = 0;
		for (int i = 1; i <= n; i++) {
			res += i;
		}
		System.out.println("方法cal02 计算结果=" + res);
	}

	public int getSum(int n1, int n2) {
		return n1+n2;
	}
}