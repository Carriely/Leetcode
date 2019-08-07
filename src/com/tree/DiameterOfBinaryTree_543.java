package com.tree;
//二叉树的直径

//解法：求所有节点中，左子树的深度+右子树的深度的最大值

public class DiameterOfBinaryTree_543 {
	private int longestPath = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		depth(root);
		return longestPath;
	}

	private int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = depth(root.left);
		int right = depth(root.right);
		longestPath = Math.max(longestPath, left + right);
		return Math.max(left, right) + 1;
	}
}
