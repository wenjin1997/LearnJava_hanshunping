public class TestPerson {
	public static void main(String[] args) {
		Person p1 = new Person("小米", 20);
		Person p2 = new Person("小米", 20);
		Person p3 = new Person("小红", 10);
		System.out.println("p1=p2?" + p2.compareTo(p1));
		System.out.println("p2=p3?" + p2.compareTo(p3));

	}
}

/**
 * 定义 Person 类，里面有 name、age 属性，
 * 并提供 compareTo 比较方法，用于判断是否和另一个人相等，
 * 提供测试类 TestPerson 用于测试, 
 * 名字和年龄完全一样，就返回 true, 否则返回 false
*/
class Person {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person() {

	}

	public boolean compareTo(Person p) {
		return this.name.equals(p.name) && p.age == this.age;
	}
}