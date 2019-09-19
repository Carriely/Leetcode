package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//组合总和 II
//要求：candidates 中的每个数字在每个组合中只能使用一次。
//思路：以 target 为根结点，依次减去数组中的数字，直到小于 0 或者等于 0，把等于 0 的结果记录到结果集中。
//回溯+剪枝
public class CombinationSum_40 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates.length == 0) {
			return res;
		}
		// 先将数组排序，因为解集不能包含重复的组合
		Arrays.sort(candidates);
		helper(candidates, 0, target, new Stack<Integer>(), res);
		return res;
	}

	// residue 表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
	// residue 在递归遍历中，只会越来越小
	private void helper(int[] candidates, int begin, int residue, Stack<Integer> stack, List<List<Integer>> res) {
		if (residue == 0) {
			res.add(new ArrayList<>(stack));
			return;
		}
		for (int i = begin; i < candidates.length && residue - candidates[i] >= 0; i++) {
			// 这一步剪枝操作基于 candidates 数组是排序数组的前提下
			if (i > begin && candidates[i] == candidates[i - 1]) {
				continue;
			}
			stack.add(candidates[i]);
			// 【关键】因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
			helper(candidates, i + 1, residue - candidates[i], stack, res);
			stack.pop();// 返回到上一级调用即可把当前stack中符合题意的组合清空
		}
	}
}
