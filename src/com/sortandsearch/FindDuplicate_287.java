package com.sortandsearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//寻找重复数
public class FindDuplicate_287 {
	// 方法一：排序
	// 时间复杂度O(nlgn)
	// 空间复杂度O(1) or O(n)
	public int findDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == nums[i + 1]) {
				return nums[i];
			}
		}
		return -1;
	}

	// 方法二：集合
	// 时间复杂度O(n)
	// 空间复杂度O(n)
	public int findDuplicate2(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int num : nums) {
			if (set.contains(num)) {
				return num;
			}
			set.add(num);
		}
		return -1;
	}

	// 环路起点问题
	// 方法二：快慢指针（抽屉原理）
	// 时间复杂度O(n)
	// 空间复杂度O(1)
	public int findDuplicate3(int[] nums) {
		int length = nums.length;
		if (length > 1) {
			// 找到快慢指针相遇的地方
			int slow = nums[0];
			int fast = nums[nums[0]];
			while (fast != slow) {
				slow = nums[slow];
				fast = nums[nums[fast]];
			}

			// 用一个新指针从头开始，直到和慢指针相遇
			fast = 0;
			while (fast != slow) {
				slow = nums[slow];
				fast = nums[fast];
			}
			return slow;
		}
		return -1;
	}
}
