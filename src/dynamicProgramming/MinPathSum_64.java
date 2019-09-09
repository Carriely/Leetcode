package dynamicProgramming;

//最小路径和
//注意边界
public class MinPathSum_64 {
	// 方法一：暴力算法
	// cost(i,j)=grid[i][j]+min(cost(i+1,j),cost(i,j+1))
	public int calculate(int[][] grid, int i, int j) {
		// 越界
		if (i == grid.length || j == grid[0].length) {
			return Integer.MAX_VALUE;
		}
		// 到达右下角
		if (i == grid.length - 1 && j == grid[0].length - 1) {
			return grid[i][j];
		}
		return grid[i][j] + Math.min(calculate(grid, i + 1, j), calculate(grid, i, j + 1));
	}

	public int minPathSum(int[][] grid) {
		return calculate(grid, 0, 0);
	}

	// 方法二：二维动态规划
	// dp(i,j)=grid(i,j)+min(dp(i+1,j),dp(i,j+1))
	// dp(i, j)dp(i,j) 表示从坐标 (i, j)(i,j) 到右下角的最小路径权值。
	// 时间复杂度 ：O(mn)
	// 空间复杂度 ：O(mn)
	public int minPathSum2(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];
		for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = grid[0].length - 1; j >= 0; j--) {
				if (i == grid.length - 1 && j != grid[0].length - 1) {
					dp[i][j] = grid[i][j] + dp[i][j + 1];
				} else if (i != grid.length - 1 && j == grid[0].length - 1) {
					dp[i][j] = grid[i][j] + dp[i + 1][j];
				} else if (i != grid.length - 1 && j != grid[0].length - 1) {
					dp[i][j] = grid[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
					dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
				} else {
					dp[i][j] = grid[i][j];
				}
			}
		}
		return dp[0][0];
	}

	// 方法三：一维动态规划
	// dp(j)=grid(i,j)+min(dp(j),dp(j+1))
	// 时间复杂度 ：O(mn)
	// 空间复杂度 ：O(n)
	public int minPathSum3(int[][] grid) {
		int[] dp = new int[grid[0].length];
		for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = grid[0].length - 1; j >= 0; j--) {
				if (i == grid.length - 1 && j != grid[0].length - 1) {
					dp[j] = grid[i][j] + dp[j + 1];
				} else if (i != grid.length - 1 && j == grid[0].length - 1) {
					dp[j] = grid[i][j] + dp[j];
				} else if (i != grid.length - 1 && j != grid[0].length - 1) {
					dp[j] = grid[i][j] + Math.min(dp[j + 1], dp[j]);
				} else {
					dp[j] = grid[i][j];
				}
			}
		}
		return dp[0];
	}

	// 方法四：不需要用额外的 dpdp 数组，而是在原数组上存储
	// grid(i,j)=grid(i,j)+min(grid(i+1,j),grid(i,j+1))
	// 时间复杂度 ：O(mn)
	// 空间复杂度 ：O(1)
	public int minPathSum4(int[][] grid) {
		for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = grid[0].length - 1; j >= 0; j--) {
				if (i == grid.length - 1 && j != grid[0].length - 1) {
					grid[i][j] = grid[i][j] + grid[i][j + 1];
				} else if (i != grid.length - 1 && j == grid[0].length - 1) {
					grid[i][j] = grid[i][j] + grid[i + 1][j];
				} else if (i != grid.length - 1 && j != grid[0].length - 1) {
					grid[i][j] = grid[i][j] + Math.min(grid[i][j + 1], grid[i + 1][j]);
				} else {
					grid[i][j] = grid[i][j];
				}
			}
		}
		return grid[0][0];
	}
}
