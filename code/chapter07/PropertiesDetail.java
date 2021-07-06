public class PropertiesDetail {
	// 编写一个main方法
	public static void main(String[] args) {
		// 创建Person对象
		// p1是对象名（对象引用）
		// new Person() 创建对象的空间（数据）才是真正的对象
		Person p1 = new Person();

		// 对象的属性默认值，遵守数组规则
		// int 0, short 0, byte 0, float 0.0, double 0.0, 
		// char \u0000, boolean false, String null

		System.out.println("\n 当前这个人的信息：");
		System.out.println("name= " + p1.name + " age= " + p1.age
			+ " sal= " + p1.sal + " isPass= " + p1.isPass);
	}
}

class Person {
	// 四个属性
	String name;
	int age;
	double sal;
	boolean isPass;
}