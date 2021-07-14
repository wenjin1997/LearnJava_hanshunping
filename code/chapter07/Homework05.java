public class Homework05 {
	public static void main(String[] args) {
		Circle c1 = new Circle(1.0);
		c1.showPerimeter();
		c1.showArea();
	}
}

/*
定义一个圆类Circle，定义属性：半径，
提供显示圆周长功能的方法，提供显示圆面积的方法。
*/
class Circle {
	double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	// 显示周长
	public void showPerimeter() {
		System.out.println("圆的周长为:" + 2 * Math.PI * this.radius);
	}

	// 显示圆面积
	public void showArea() {
		System.out.println("圆的面积为：" + Math.PI * this.radius * this.radius);
	}

}