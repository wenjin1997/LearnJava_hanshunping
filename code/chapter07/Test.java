public class Test { //公有类
	int count = 9;
	public void count1() {
		count = 10;
		System.out.println("count1=" + count);
	}
	public void count2() {
		System.out.println("count1=" + count++);
	}

	//这是Test类的main方法，任何一个类，都可以有main方法
	public static void main(String[] args) {
		//1.new Test() 是匿名对象，匿名对象使用后，就不能使用
		//2.new Test().count1();创建好匿名对象后，就调用count1()
		new Test().count1();
		Test t1 = new Test();
		t1.count2();
		t1.count2();
	}
}