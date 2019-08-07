package com.sortandsearch;

//只出现一次的数字
//解法：
//对数组中的所有元素进行异或操作，最后结果就是只出现一次的数字
public class SingleNumber_136 {
	public int singleNumber(int[] nums) {
		int ans = nums[0];
		for (int i = 0; i < nums.length; i++) {
			ans ^= nums[i];
		}
		return ans;
	}
}
