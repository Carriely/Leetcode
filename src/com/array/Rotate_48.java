package com.array;

//旋转图像
public class Rotate_48 {
	// 转置加翻转
	// 时间复杂度：O(N^2)
	// 空间复杂度：O(1)
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		// transpose matrix     
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {//j和i相等的位置交换
				int temp = matrix[j][i];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
		// reverse each row
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = temp;
			}
		}
	}
}
