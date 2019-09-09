package backtracking;
//全排列 II

//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//思路：回溯+剪枝
//关键：当数组中，有了重复元素的时候，我们可以先把数组排个序，这样在递归的过程中就可以很容易发现重复的元素。
//当发现重复元素的时候，让这一个分支跳过，就达到了“剪枝”的效果，重复的排列就不会出现在结果集中。
//参考：https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PermuteUnique_47 {
	private List<List<Integer>> res = new ArrayList<>();
	private boolean[] used;

	public List<List<Integer>> permuteUnique(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return res;
		}
		Arrays.sort(nums);
		used = new boolean[nums.length];
		findPermuteUnique(nums, 0, new Stack<Integer>());
		return res;
	}

	private void findPermuteUnique(int[] nums, int depth, Stack<Integer> stack) {
		if (depth == nums.length) {
			res.add(new ArrayList<>(stack));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				// 因为排序以后重复的数一定不会出现在开始，故 i > 0
                // 和之前的数相等，并且之前的数(nums[i-1])还未使用过，只有出现这种情况，才会出现相同分支，跳过这种情况
				if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
					continue;
				}
				used[i] = true;
				stack.add(nums[i]);
				findPermuteUnique(nums, depth + 1, stack);
				used[i] = false;
				stack.pop();
			}
		}
	}
}
