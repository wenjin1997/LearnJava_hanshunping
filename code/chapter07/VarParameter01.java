public class VarParameter01 {
	public static void main(String[] args) {
		HspMethod m = new HspMethod();
		System.out.println(m.sum(10, 20, 30));
		System.out.println(m.sum());
	}
}

class HspMethod {
	// 方法sum 可以计算多个数的和
	// 用可变参数,使用时可以把nums当成数组
	public int sum(int... nums) {
		int res = 0;
		for(int i = 0; i < nums.length; i++) {
			res += nums[i];
		}
		return res;
	} 
}