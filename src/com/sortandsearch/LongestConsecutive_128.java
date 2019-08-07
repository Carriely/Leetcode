package com.sortandsearch;

//最长连续序列
//要求：时间复杂度：O(n)
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive_128 {
	// 方法一：排序
	// 时间复杂度：O(nlgn)
	public int longestConsecutive(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return 0;
		}
		int longestStreak = 0;
		int currentStreak = 0;
		Arrays.sort(nums);

		for (int i = 1; i <= nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				if (nums[i] == nums[i - 1] - 1) {
					currentStreak += 1;
				} else {
					longestStreak = Math.max(currentStreak, longestStreak);
					currentStreak = 1;
				}
			}
		}
		return Math.max(longestStreak, currentStreak);
	}

	// 方法二：哈希表和线性空间的构造
	// 与暴力算法不同，用一个 HashSet 保存所有的数字，实现 O(1) 时间的查询；
	// 同时，只对 当前数字 - 1 不在哈希表里的数字，作为连续序列的第一个数字去找对应的最长序列，这是因为其他数字一定已经出现在了某个序列里。
	// 时间复杂度：O(n)
	// 空间复杂度：O(n)
	public int longestConsecutive2(int[] nums) {
		Set<Integer> numset = new HashSet<>();
		for (int num : nums) {
			numset.add(num);
		}
		int longestStreak = 0;
		for (int num : numset) {
			if (!numset.contains(num - 1)) {
				int currentNum = num;
				int currentStreak = 0;

				while (numset.contains(currentNum)) {
					currentNum += 1;
					currentStreak += 1;
				}

				longestStreak = Math.max(currentStreak, longestStreak);
			}
		}
		return longestStreak;
	}

}
