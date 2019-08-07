package com.sortandsearch;

import java.util.PriorityQueue;
import java.util.Queue;

//数组中的第K个最大元素
public class FindKthLargest_215 {
	// 方法一：排序（快排），返回nums[len(nums) - k]，时间复杂度为O(nlogn)
	// 方法二：冒泡排序排列前k个元素（时间慢）
	
	// 方法三：堆，时间复杂度为O(nlogk)
	// 建立一个小顶堆，先把nums中[0, k)的元素添加至小顶堆；
	// 对于[k, len(nums) - 1]的元素，判断其与小顶堆堆顶元素大小关系，若大于则push进堆（每次push进堆时间复杂度为O(logk)），并将堆顶元素pop，这样做是为了保证小顶堆中始终有k个元素；
	// 根据以上机制，最终小顶堆中将会保存最大的k个元素，且堆顶为此k元素里最小的那个，即为第k个最大元素。
	public int findKthLargest(int[] nums, int k) {
		Queue<Integer> heap = new PriorityQueue<>();// PriorityQueue优先队列的作用是能保证每次取出的元素都是队列中权值最小的
		for (int i = 0; i < k; i++) {
			heap.add(nums[i]);
		}
		for (int i = k; i < nums.length; i++) {
			if (nums[i] > heap.peek()) {
				heap.remove();
				heap.add(nums[i]);
			}
		}
		return heap.peek();
	}

}
