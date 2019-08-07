package com.sortandsearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

//前 K 个高频元素
public class TopKFrequent_347 {
	// 方法一：暴力排序，快排时间复杂度O(nlog⁡n)
	// 方法二：最小堆，时间复杂度O(nlogk)，堆中添加一个元素的复杂度是 O(log(k))
//	借助 哈希表 来建立数字和其出现次数的映射，遍历一遍数组统计元素的频率
//	维护一个元素数目为 k 的最小堆
//	每次都将新的元素与堆顶元素（堆中频率最小的元素）进行比较，如果新的元素的频率比堆顶端的元素大，则弹出堆顶端的元素，将新的元素添加进堆中
//	最终，堆中的 k 个元素即为前 k 个高频元素
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		final HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		// 遍历map，用最小堆保存频率最大的k个元素
		PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				return map.get(a) - map.get(b);
			}
		});
		for (int key : map.keySet()) {
			if (heap.size() < k) {
				heap.add(key);
			} else if (map.get(key) > map.get(heap.peek())) {
				heap.poll();
				heap.add(key);
			}
		}

		while (!heap.isEmpty()) {
			res.add(heap.poll());
		}
		// 重排序
		Collections.reverse(res);
		return res;
	}

	// 方法三：桶排序法，时间复杂度：O(n)
	// 首先依旧使用哈希表统计频率
	// 统计完成后，创建一个list数组，将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标即可。
	public List<Integer> topKFrequent2(int[] nums, int k) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		final HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		// 桶排序
		// 将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
		List<Integer>[] list = new List[nums.length + 1];
		for (int key : map.keySet()) {
			int i = map.get(key);
			if (list[i] == null) {
				list[i] = new ArrayList<>();
			}
			list[i].add(key);
		}
		// 倒序遍历数组获取出现顺序从大到小的排列
		for (int i = list.length - 1; i >= 0 && res.size() < k; i--) {
			if (list[i] == null)
				continue;
			res.addAll(list[i]);
		}
		return res;
	}
}
