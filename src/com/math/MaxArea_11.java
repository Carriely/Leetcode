package com.math;

//盛最多水的容器
public class MaxArea_11 {
	// 暴力法
	// 时间复杂度：O(n^2)
	// 空间复杂度：O(1)
	public int maxArea(int[] height) {
		int maxarea = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
			}
		}
		return maxarea;
	}

	// 双指针法
	// 时间复杂度：O(n)
	// 空间复杂度：O(1)
	public int maxArea2(int[] height) {
		int maxarea = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * (right - left));
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxarea;
	}
}
