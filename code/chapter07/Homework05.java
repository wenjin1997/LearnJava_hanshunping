public class Homework05 {
	public static void main(String[] args) {
		Circle c1 = new Circle(1.0);
		System.out.println("圆的周长=" + c1.Area() + " 面积=" + c1.Perimeter());
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

	// 周长
	public double Perimeter() {
		return 2 * Math.PI * this.radius;
	}

	// 圆面积
	public double Area() {
		return Math.PI * this.radius * this.radius;
	}

}