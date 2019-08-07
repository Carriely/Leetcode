package com.math;

//***
//买卖股票的最佳时机 IV(hard)
//最多可以完成 k 笔交易
public class MaxProfit_188 {
	public int maxProfit(int max_k, int[] prices) {
		int n = prices.length;
		if (max_k > n / 2)
			return maxProfit_k_inf(prices);

		int[][][] dp = new int[n][max_k + 1][2];
		for (int i = 0; i < n; i++)
			for (int k = max_k; k >= 1; k--) {
				if (i - 1 == -1) {
					dp[i][k][0] = 0;
					// 解释：
					// dp[i][0]
					// = max(dp[-1][0], dp[-1][1] + prices[i])
					// = max(0, -infinity + prices[i]) = 0
					dp[i][k][1] = -prices[i];
					// 解释：
					// dp[i][1]
					// = max(dp[-1][1], dp[-1][0] - prices[i])
					// = max(-infinity, 0 - prices[i])
					// = -prices[i]
					continue;
				}
				dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
				dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
			}
		return dp[n - 1][max_k][0];
	}

	private int maxProfit_k_inf(int[] prices) {
		int n = prices.length;
		int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int temp = dp_i_0;
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
		}
		return dp_i_0;
	}
}
