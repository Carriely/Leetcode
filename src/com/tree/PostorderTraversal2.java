package com.tree;

import java.util.ArrayList;
import java.util.Stack;

//二叉树的后序遍历
//解法：
//要保证根结点在左孩子和右孩子访问之后才能访问，因此对于任一结点P，先将其入栈。
// 如果P不存在左孩子和右孩子，则可以直接访问它；
// 或者P存在孩子，但是其孩子都已被访问过了，则同样可以直接访问该结点
// 若非上述两种情况，则将P的右孩子和左孩子依次入栈，这样就保证了
// 每次取栈顶元素的时候，左孩子在右孩子前面被访问，左孩子和右孩子都在根结点前面被访问。
public class PostorderTraversal2 {
	// 非递归算法
	public ArrayList<Integer> postOrder(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur;// 定义指针，指向当前节点
		TreeNode pre = null;// 定义指针，指向上一个访问的节点
		// 先将树的根节点入栈
		stack.push(root);
		while (!stack.isEmpty()) {
			// 当前节点置为栈顶节点
			cur = stack.peek();
			if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
				// 如果当前节点没有左右孩子，或者有左孩子或右孩子，但已经被访问输出
				// 则直接输出该节点，将其出栈，将其设为上一个访问的节点
				result.add(root.val);
				stack.pop();
				pre = cur;
			} else {
				// 如果不满足上面两种情况,则将其右孩子、左孩子依次入栈
				if (cur.right != null) {
					stack.push(cur.right);
				}
				if (cur.left != null) {
					stack.push(cur.left);
				}
			}

		}
		return result;
	}
}
