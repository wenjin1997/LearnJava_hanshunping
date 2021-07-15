public class Homework03 {
	public static void main(String[] args) {
		Book book = new Book("《飘》", 120);
		book.info();
		book.updatePrice();
		book.info();
	}
}

/*
编写类Book,定义方法updatePrice，
实现更改某本书的价格，
具体：如果价格>150，则更改为150，
如果价格>100，更改为100，否则不变。
*/
class Book {
	String name;
	double price;

	public Book(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public void updatePrice() {
		if(this.price > 150) {
			this.price = 150;
		} else if(this.price > 100) {
			this.price = 100;
		}
	}

	public void info() {
		System.out.println("【书籍信息】 书名：" + name + " 价格：" + price);
	}
}