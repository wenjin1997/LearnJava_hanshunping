// 转义字符练习
public class ChangeChar {
	public static void main(String[] args) {
		// \t 制表符 
		// \r 回车，光标会移到当前行的第一个字符前
		// \n 换行符
		System.out.println("书名\t作者\t价格\t销量\r\n三国\t罗贯中\t120\t1000");

		// \\ 一个反斜杠
		System.out.println("D:\\code\\java");
	}
}