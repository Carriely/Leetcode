package dfs;

import java.util.ArrayList;
import java.util.List;

//***
//第k个排列
//参考：https://leetcode-cn.com/problems/permutation-sequence/solution/hui-su-jian-zhi-python-dai-ma-java-dai-ma-by-liwei/
//剪枝
public class GetPermutation_60 {
	public String getPermutation(int n, int k) {
		int[] array = new int[n];
		boolean[] used = new boolean[n];
		for (int i = 0; i < n; i++) {
			array[i] = i + 1;
			used[i] = false;
		}
		List<String> list = new ArrayList<String>();
		return dfs(array, used, n, k, 0, list);
	}

	// 求阶乘
	private int factorial(int n) {
		// 这种编码方式包括了 0 的阶乘是 1 这种情况
		int res = 1;
		while (n > 0) {
			res *= n;
			n--;
		}
		return res;
	}

	private String dfs(int[] array, boolean[] used, int n, int k, int depth, List<String> list) {
		if (depth == n) {
			StringBuilder sb = new StringBuilder();
			for (String s : list) {
				sb.append(s);
			}
			return sb.toString();
		}
		int ps = factorial(n - depth - 1);
		for (int i = 0; i < n; i++) {
			if (used[i]) {
				continue;
			}
			if (ps < k) {
				k -= ps;
				continue;
			}
			list.add(array[i] + "");
			used[i] = true;
			return dfs(array, used, n, k, depth + 1, list);
		}
		throw new RuntimeException("参数错误");
	}
}
