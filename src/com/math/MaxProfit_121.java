package com.math;

//买卖股票的最佳时机
public class MaxProfit_121 {
	// 一次遍历，时间复杂度：O(n)。空间复杂度：O(1)，只使用了两个变量。
	public int maxProfit(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			} else if (prices[i] - minPrice > maxProfit) {
				maxProfit = prices[i] - minPrice;
			}
		}
		return maxProfit;
	}

	// 状态机
	// 空间复杂度 O(n)
	public int maxProfit1(int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n][2];
		for (int i = 0; i < n; i++) {
			if (i - 1 == -1) {
				dp[i][0] = 0;
				// 解释：
				// dp[i][0]
				// = max(dp[-1][0], dp[-1][1] + prices[i])
				// = max(0, -infinity + prices[i]) = 0
				dp[i][1] = -prices[i];
				// 解释：
				// dp[i][1]
				// = max(dp[-1][1], dp[-1][0] - prices[i])
				// = max(-infinity, 0 - prices[i])
				// = -prices[i]
				continue;
			}
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
		}
		return dp[n - 1][0];
	}

	// 状态机
	// 空间复杂度 O(1)
	// k == 1
	public int maxProfit_k_1(int[] prices) {
		int n = prices.length;
		// base case: dp[-1][0] = 0, dp[-1][1] = -infinity
		int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			// dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			// dp[i][1] = max(dp[i-1][1], -prices[i])
			dp_i_1 = Math.max(dp_i_1, -prices[i]);
		}
		return dp_i_0;
	}

}
