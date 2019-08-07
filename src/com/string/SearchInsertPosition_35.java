package com.string;
//搜索插入位置
public class SearchInsertPosition_35 {
	//基本解法
	public static int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++) {
        	if(nums[i] == target || nums[i] > target) {
        		return i;
        	}
        }
        return nums.length;
    }
	//提高效率：二分法
	public static int searchInsert2(int[] nums, int target) {
		int start = 0;
        int end = nums.length-1;
        while(start <= end) {
        	int mid = (start + end) / 2;
        	if(nums[mid] < target){
        		start = mid + 1;
        	}else if(nums[mid] > target) {
        		end = mid - 1;
        	}else {
        		return mid;
        	}
        }
        return start;
    }
	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		System.err.println(searchInsert2(nums, 4));
	}
}
