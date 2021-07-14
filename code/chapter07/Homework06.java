public class Homework06 {
	public static void main(String[] args) {
		Cale c1 = new Cale(10, 20);
		System.out.println("第一个类：和=" + c1.sum() + " 差=" + c1.dif() + 
			" 乘=" + c1.multiply() + " 商=" + c1.divide());

		Cale c2 = new Cale(100, 0);
		System.out.println("第二个类：和=" + c2.sum() + " 差=" + c2.dif() + 
			" 乘=" + c2.multiply() + " 商=" + c2.divide());

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
	public double divide() {
		if(op2 == 0) {
			System.out.println("除数为0了！");
			return 0;
		} else {
			return op1 / op2;
		}
	}

}