public class Homework07 {
	public static void main(String[] args) {
		Dog d1 = new Dog("小白", "white", 5);
		d1.show();
	}
}

/*
设计一个Dog类，有名字、颜色和年龄属性，
定义输出方法show()显示其信息。
并创建对象，进行测试。【提示this.属性】
*/
class Dog {
	String name;
	String color;
	int age;

	public Dog(String name, String color, int age) {
		this.name = name;
		this.color = color;
		this.age = age;
	}

	public Dog() {

	}

	public void show() {
		System.out.println("小狗的信息：");
		System.out.println("名字\t颜色\t年龄");
		System.out.println(this.name + "\t" + this.color + "\t" + this.age);
	}
}