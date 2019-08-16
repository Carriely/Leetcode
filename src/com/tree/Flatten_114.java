package com.tree;

//***
//二叉树展开为链表
//要求：原地展开
public class Flatten_114 {
	public TreeNode last = null;

	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		if (last != null) {
			last.left = null;
			last.right = root;
		}
		last = root;
		// 备份右子树节点
		TreeNode copyRight = last.right;
		flatten(root.left);
		flatten(copyRight);
	}
}
