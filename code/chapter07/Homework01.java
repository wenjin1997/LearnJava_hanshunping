public class Homework01 {
	public static void main(String[] args) {
		A01 a = new A01();
		double[] nums = {1};
		Double res = a.max(nums);
		if(res != null) {
			System.out.println("数组的最大值=" + res);
		} else {
			System.out.println("输入的数组有误，数组不能为null，或者{}");
		}
		
	}
}

/*
定义方法max，实现求某个double数组的最大值，并返回
*/
class A01 {
	public Double max(double[] nums) {
		// Double是包装类

		// 先保证数组不能为null
		// 保证nums至少有一个元素
		if(nums != null && nums.length > 0) {
			double ans = nums[0];
			for(int i = 1; i < nums.length; i++) {
				if(nums[i] > ans) {
					ans = nums[i];
				}
			}
			return ans;
		} else {
			return null;
		}
	}
}