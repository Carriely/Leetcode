package com.array;
//组合求和
//思路：回溯+剪枝
//解法：
//本题采用递归较容易解答。
//首先，将数组内的元素由小到大排序，然后不断地进行试探，直到和为target。
//若当前和小于target，则继续往里面加元素；若当前和等于target，就可以将结果保留下来；若当前和已经大于target，那就可以排除掉这种情况，回溯到上一层，寻找其他可能的组合。
//candidates 中的数字可以无限制重复被选取。
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {
	private List<List<Integer>> res;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		res = new ArrayList<List<Integer>>();
		if (candidates.length == 0 || candidates == null) {
			return null;
		}
		List<Integer> list = new ArrayList<Integer>();
		// 排序帮助去重与剪枝优化
		Arrays.sort(candidates);
		helper(candidates, list, 0, target);
		return res;
	}

	private void helper(int[] nums, List<Integer> list, int index, int target) {
		if (target == 0) {
			res.add(new ArrayList<>(list));
			return;
		}
		// target >= nums[i] 剪枝优化，如果target比nums[i]还小了，没必要再进行下去了
		for (int i = index; i < nums.length && target >= nums[i]; i++) {
			list.add(nums[i]);
			helper(nums, list, i, target - nums[i]);
			list.remove(list.size() - 1);
		}
	}

}
