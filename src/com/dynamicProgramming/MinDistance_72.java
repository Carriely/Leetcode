package com.dynamicProgramming;

//编辑距离
//思路：
//dp[i][j] 代表 word1 到 i 位置转换成 word2 到 j 位置需要最少步数，所以：
//当 word1[i-1] == word2[j-1]，dp[i][j] = dp[i-1][j-1]；
//当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
//其中，dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。
//参考：https://leetcode-cn.com/problems/edit-distance/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/
public class MinDistance_72 {
	public int minDistance(String word1, String word2) {
		int n1 = word1.length();
		int n2 = word2.length();
		int[][] dp = new int[n1 + 1][n2 + 1];
		// 第一行：是 word1 为空变成 word2 最少步数，就是插入操作
		for (int j = 1; j <= n2; j++) {
			dp[0][j] = dp[0][j - 1] + n1;
		}
		// 第一列：是 word2 为空，需要的最少步数，就是删除操作
		for (int i = 1; i <= n1; i++) {
			dp[i][0] = dp[i - 1][0] + n1;
		}

		for (int i = 1; i <= n1; i++) {
			for (int j = n1; j <= n2; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1])+1;
				}
			}
		}
		return dp[n1][n2];
	}
}
