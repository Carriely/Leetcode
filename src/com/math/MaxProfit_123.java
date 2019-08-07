package com.math;
//***
//买卖股票的最佳时机 III(hard)
//最多可以完成 两笔 交易
public class MaxProfit_123 {
	// 状态机
//	public int maxProfit(int[] prices) {
//		int max_k = 2;
//		int n = prices.length;
//		int[][][] dp = new int[n][max_k + 1][2];
//		for (int i = 0; i < n; i++) {
//			for (int k = max_k; k >= 1; k--) {
//				if (i - 1 == -1) {
//					dp[i][k][0] = 0;
//					// 解释：
//					// dp[i][0]
//					// = max(dp[-1][0], dp[-1][1] + prices[i])
//					// = max(0, -infinity + prices[i]) = 0
//					dp[i][k][1] = -prices[i];
//					// 解释：
//					// dp[i][1]
//					// = max(dp[-1][1], dp[-1][0] - prices[i])
//					// = max(-infinity, 0 - prices[i])
//					// = -prices[i]
//					continue;
//
//				}
//				dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
//				dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
//			}
//		}
//		// 穷举了 n × max_k × 2 个状态，正确。
//		return dp[n - 1][max_k][0];
//	}
}