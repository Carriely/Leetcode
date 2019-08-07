package com.sortandsearch;

import java.util.Arrays;

//求众数
//解法：
//1、先排序，再找到中间位置的数
//2、多数投票法
//剑指 offer有详解
public class MajorityElement_169 {
	public int majorityElement(int[]nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
}
