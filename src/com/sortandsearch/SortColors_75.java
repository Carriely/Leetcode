package com.sortandsearch;
//荷兰三色旗问题
//思路：
//用三个指针（p0, p2 和curr）来分别追踪0的最右边界，2的最左边界和当前考虑的元素。
//沿着数组移动 curr 指针，若nums[curr] = 0，则将其与 nums[p0]互换；若 nums[curr] = 2 ，则与 nums[p2]互换。
//算法：
//初始化0的最右边界：p0 = 0。在整个算法执行过程中 nums[idx < p0] = 0.
//初始化2的最左边界 ：p2 = n - 1。在整个算法执行过程中 nums[idx > p2] = 2.
//初始化当前考虑的元素序号 ：curr = 0.
//While curr <= p2 :
//若 nums[curr] = 0 ：交换第 curr个 和 第p0个 元素，并将指针都向右移。
//若 nums[curr] = 2 ：交换第 curr个和第 p2个元素，并将 p2指针左移 。
//若 nums[curr] = 1 ：将指针curr右移。
public class SortColors_75 {
	//时间复杂度 :O(N) 
	//空间复杂度 :O(1) 
	public void sortColors(int[] nums) {
		int p0=0;
		int curr=p0;
		int p2 = nums.length-1;
		
		int temp;
		while(curr<=p2) {
			if(nums[curr]==0) {
				// 交换第p0个和第curr个元素
		        // p0++
				// curr++
				temp = nums[p0];
				nums[p0++] = nums[curr];
				nums[curr++] = temp;
			}else if(nums[curr]==2) {
				// 交换第p2个和第curr个元素
		        // p2--
				temp = nums[p2];
				nums[p2--] = nums[curr];
				nums[curr] = temp;
				//因为左边交换完, nums[curr]的的值是0。一定要往后挪一位继续扫描。 
				//而右边交换完，nums[curr]是之前的nums[p2]的值，这个值是没有被扫描过的，所以不用挪一位，直接扫描curr。
			}else {
				curr++;
			}
		}
	}

}
