public class ConstructorDetail {
	public static void main(String[] args) {
		Dog d = new Dog();

	}
}

class Dog {
	public Dog(String dName) {

	}

	Dog() {

	}
}

class Person {
	String name;
	int age;

	// 第一个构造器
	public Person(String pName, int pAge) {
		name = pName;
		age = pAge;
	}

	// 第二个构造器
	public Person(String pName) {
		name = pName;
	}
}