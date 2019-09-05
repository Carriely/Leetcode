package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//子集 II
//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。要求：解集不能包含重复的子集。
//解题关键：排序
public class SubsetsWithDup_90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length == 0 || nums == null) {
			return res;
		}
		// 排序
		Arrays.sort(nums);
		backtrack(0, nums, new ArrayList<Integer>(), res);
		return res;
	}

	private void backtrack(int start, int[] nums, ArrayList<Integer> temp, List<List<Integer>> res) {
		res.add(new ArrayList<>(temp));
		for (int i = start; i < nums.length; i++) {
			// 和上个数字相等就跳过
			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}
			temp.add(nums[i]);
			backtrack(i + 1, nums, temp, res);
			temp.remove(temp.size() - 1);
		}
	}
}
