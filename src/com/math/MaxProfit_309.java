package com.math;
//最佳买卖股票时机含冷冻期
//每次 sell 之后要等一天才能继续交易。
public class MaxProfit_309 {
	//状态机
	// dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
	// dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
	// 注意：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。
	public int maxProfit_with_cool(int[] prices) {
	    int n = prices.length;
	    int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
	    int dp_pre_0 = 0; // 代表 dp[i-2][0]
	    for (int i = 0; i < n; i++) {
	        int temp = dp_i_0;
	        dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
	        dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
	        dp_pre_0 = temp;
	    }
	    return dp_i_0;
	}
}
