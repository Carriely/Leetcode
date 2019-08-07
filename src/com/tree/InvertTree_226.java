package com.tree;
//翻转二叉树
public class InvertTree_226 {
	public TreeNode invertTree(TreeNode root) {
		if (root == null && !hasChild(root)) {
			return root;
		}
		TreeNode node = root.left;
		root.left = root.right;
		root.right = node;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}

	public boolean hasChild(TreeNode root) {
		return root.left != null || root.right != null;
	}
}
