package com.array;

//和为K的子数组
public class SubarraySum_560 {
	// 方法一：暴力法
	// 时间复杂度O(N^2)
	// 空间复杂度O(1)
	public int subarraySum(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum == k) {
					res++;
				}
			}
		}
		return res;
	}

	// 哈希表
	// 时间复杂度O(N)
	// 空间复杂度O(1)
	public int subarraySum2(int[] nums, int k) {
		return 0;
	}
}
