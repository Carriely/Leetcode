package com.tree;
//二叉树的最小深度
//解法：
//二叉树的经典问题之最小深度问题就是就最短路径的节点个数
//深度优先搜索DFS
//注意：
//如果左子树为空的话，返回的是右子树的最小深度+1
//如果右子树为空的话，返回的是左子树的最小深度为1
public class MinimumDepth {
	//递归算法
	public int minDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int minLeft = minDepth(root.left);
		int minRight = minDepth(root.right);
		if(minLeft==0&&minRight>0) {
			return minRight+1;
		}else if(minRight==0&&minLeft>0) {
			return minLeft+1;
		}else {
			return Math.min(minLeft, minRight)+1;
		}
	}
	//非递归算法
}
