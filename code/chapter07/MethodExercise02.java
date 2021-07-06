public class MethodExercise02 {
	public static void main(String[] args) {
		Person p = new Person();
		p.name = "小明";
		p.age = 100;

		MyTools tool = new MyTools();
		Person p2 = tool.copyPerson(p);

		System.out.println("p的属性：name= " + p.name + " age=" + p.age);
		System.out.println("p2的属性：name= " + p2.name + " age=" + p2.age);

		// 判断p和p2是否为同一对象
		System.out.println(p == p2);
	}
}

class Person {
	String name;
	int age;
}

class MyTools {
	// 编写一个方法copyPerson，可以复制一个Person对象，返回复制的对象。
	// 克隆对象，注意要求得到新对象和原来的对象是两个独立的对象，只是他们的属性相同
	public Person copyPerson(Person p) {
		Person p2 = new Person();
		p2.name = p.name;
		p2.age = p.age;
		return p2;
	}
}