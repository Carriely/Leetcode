package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//全排列
//思路：回溯算法（深度优先遍历）
//排列问题，只要我们按照顺序选取数字，保证上一层选过的数字不在下一层出现，就能够得到不重不漏的所有排列。
//参考：https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
public class Permute_46 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length == 0 || nums == null) {
			return res;
		}
		boolean[] visited = new boolean[nums.length];
		generatePermution(nums, visited, 0, new Stack<Integer>(), res);
		return res;
	}

	private void generatePermution(int[] nums, boolean[] visited, int curSize, Stack<Integer> stack,
			List<List<Integer>> res) {
		if (curSize == nums.length) {
			res.add(new ArrayList<>(stack));
		}
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				stack.push(nums[i]);
				generatePermution(nums, visited, curSize + 1, stack, res);
				// 状态重置
				visited[i] = false;
				stack.pop();
			}
		}
	}
}
