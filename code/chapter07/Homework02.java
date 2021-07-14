public class Homework02 {
	public static void main(String[] args) {
		A02 a = new A02();
		String[] strs = {"a","b","c"};
		System.out.println(a.find("b",strs));

	}
}
/*
编写类A02,定义方法find，
实现查找某字符串是否在字符串数组中，
并返回索引，如果找不到，返回-1.
*/
class A02 {
	public int find(String str, String[] strs) {
		for(int i = 0; i < strs.length; i++) {
			if(str.equals(strs[i])) {
				return i;
			}
		}
		return -1;
	}
}