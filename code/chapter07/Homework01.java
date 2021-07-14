public class Homework01 {
	public static void main(String[] args) {
		double[] nums = {1.2, 2.3, 9.0, 10, 0.1};
		A01 a = new A01();
		System.out.println(a.max(nums));
	}
}

/*
定义方法max，实现求某个double数组的最大值，并返回
*/
class A01 {
	public double max(double[] nums) {
		double ans = nums[0];
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] > ans) {
				ans = nums[i];
			}
		}
		return ans;
	}
}