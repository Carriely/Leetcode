package com.sortandsearch;

//在排序数组中查找元素的第一个和最后一个位置，要求时间复杂度是O(log n) 级别
//二分法
public class SearchRange_34 {
	public int[] searchRange(int[] nums, int target) {
		int[] resArr = { -1, -1 };
		int head = 0;
		int last = nums.length - 1;
		boolean flag = false;
		while (last >= head) {
			int mid = (head + last) / 2;
			if (nums[mid] == target) {
				head = mid;
				last = mid;
				flag = true;
				break;
			} else if (nums[mid] > target) {
				last = mid - 1;
			} else if (nums[mid] < target) {
				head = mid + 1;
			}
		}
		// 找到目标值
		if (flag) {
			while (head != 0 && nums[head] == nums[head - 1]) {
				head--;
			}
			while (last != nums.length - 1 && nums[last] == nums[last + 1]) {
				last++;
			}
			resArr[0] = head;
			resArr[1] = last;
		}
		return resArr;
	}
}
