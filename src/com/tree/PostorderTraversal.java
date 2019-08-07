package com.tree;

import java.util.ArrayList;

//二叉树的后序遍历
public class PostorderTraversal {
	//递归解法
	public ArrayList<Integer> postorder(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		help(result, root);
		return result;
	}

	public void help(ArrayList<Integer> list, TreeNode root) {
		if (root == null) {
			return;
		}
		help(list, root.left);
		help(list, root.right);
		list.add(root.val);
	}
}
