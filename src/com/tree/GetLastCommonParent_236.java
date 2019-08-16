package com.tree;
//二叉树的最近公共祖先
public class GetLastCommonParent_236 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		// 如果有一个match，则说明当前node就是要找的最低公共祖先
		if (root.equals(p) || root.equals(q)) {
			return root;
		}

		TreeNode commonInLeft = lowestCommonAncestor(root.left, p, q);
		TreeNode commonInRight = lowestCommonAncestor(root.right, p, q);
		// 如果一个左子树找到，一个在右子树找到，则说明root是唯一可能的最低公共祖先
		if (commonInLeft != null && commonInRight != null) {
			return root;
		}
		// 其他情况是要不然在左子树要不然在右子树
		if (commonInLeft != null) {
			return commonInLeft;
		}
		return commonInRight;
	}
}
