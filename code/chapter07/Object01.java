public class Object01 {
	public static void main(String[] args) {
		// 使用OOP面向对象
		// 创建cat1对象
		Cat cat1 = new Cat();
		cat1.name = "小白";
		cat1.age = 10;
		cat1.color = "白色";

		// 创建cat2对象
		Cat cat2 = new Cat();
		cat2.name = "小花";
		cat2.age = 100;
		cat2.color = "花色";

		// 使用类
		System.out.println("第1只小猫：" + cat1.name +
			" " + cat1.age + " " + cat1.color);
		System.out.println("第2只小猫：" + cat2.name +
			" " + cat2.age + " " + cat2.color);
	}
}

// 猫类
class Cat {
	String name; // 名字
	int age; // 年龄
	String color; // 颜色
}
