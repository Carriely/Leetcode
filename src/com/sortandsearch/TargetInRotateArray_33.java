package com.sortandsearch;

//搜索旋转排序数组，要求时间复杂度是 O(log n) 级别
//思路：如果中间的数小于最右边的数，则右半段是有序的，若中间数大于最右边数，则左半段是有序的，
//我们只要在有序的半段里用首尾两个数来判断目标值是否在这一区域内，这样就可以确定保留哪半边了。
public class TargetInRotateArray_33 {
	public int targetInRotateArray(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < nums[right]) {
				if (nums[mid] < target && target < nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				if (nums[left] < target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return -1;
	}
}
