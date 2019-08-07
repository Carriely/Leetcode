package com.math;
//**
//买卖股票的最佳时机 II
//交易次数不限
public class MaxProfit_122 {
	// 状态机
	// 如果 k 为正无穷，那么就可以认为 k 和 k - 1 是一样的
	// 状态转移方程：
	// dp[i][0]=max(dp[i-1][0], dp[i-1][1] + prices[i])
	// dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
	public int maxProfit_k_inf(int[] prices) {
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
