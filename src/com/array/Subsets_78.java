package com.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//子集
//思路：回溯
public class Subsets_78 {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 1) {
			return res;
		}
		backtrack(nums, 0, new ArrayList<Integer>(), res);
		return res;
	}

	private void backtrack(int[] nums, int index, ArrayList<Integer> temp, List<List<Integer>> res) {
		res.add(new ArrayList<>(temp));
		for (int i = index; i < nums.length; i++) {
			temp.add(nums[i]);
			backtrack(nums, i + 1, temp, res);
			temp.remove(temp.size()-1);
		}

	}
}
