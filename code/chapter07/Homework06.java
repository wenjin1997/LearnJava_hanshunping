public class Homework06 {
	public static void main(String[] args) {
		Cale c1 = new Cale(10, 20);
		System.out.println("和=" + c1.sum());
		System.out.println("差=" + c1.dif());
		System.out.println("乘=" + c1.multiply());
		Double div = c1.divide();
		if(div != null) {
			System.out.println("商=" + c1.divide());
		}
	}
}

/*
编程创建一个Cale计算类，在其中定义2个变量表示两个操作数，
定义四个方法实现求和、差、乘、商（要求除数为0的话，要提示）
并创建两个对象，分别测试。
*/
class Cale {
	double op1;
	double op2;

	public Cale(double op1, double op2) {
		this.op1 = op1;
		this.op2 = op2;
	}

	//和
	public double sum() {
		return op1 + op2;
	}

	//差
	public double dif() {
		return op1 - op2;
	}

	//乘
	public double multiply() {
		return op1 * op2;
	}

	//商
	public Double divide() {
		if(op2 == 0) {
			System.out.println("除数不能为0！");
			return null;
		} else {
			return op1 / op2;
		}
	}

}