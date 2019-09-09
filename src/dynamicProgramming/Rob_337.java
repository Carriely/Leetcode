package dynamicProgramming;

import com.tree.TreeNode;

//***
//打家劫舍
//树形dp问题（递归）
public class Rob_337 {
	// 解法一
	public int rob(TreeNode root) {
		int[] res = doRob(root);
		return Math.max(res[0], res[1]);
	}

	// res[0]为不包括根节点的最大值，res[1]为包括根节点的最大值
	public int[] doRob(TreeNode root) {
		int[] res = new int[2];
		if (root == null) {
			return res;
		}
		int[] left = doRob(root.left);
		int[] right = doRob(root.right);
		// 不包含根节点，最大值为两个子树的最大值之和
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		// 包含根节点，最大值为两个子树不包含根节点的最大值加上根节点的值
		res[1] = left[0] + right[0] + root.val;
		return res;
	}

	// 解法二：可以把根节点看作一个很特殊的节点。因为打劫直接相连的房子会引发报警，所以当打劫了根节点后，便不能打劫左右的子节点。
	// 那么，就可以把问题简化成打劫根节点与不打劫根节点中求最大值的问题。
	// 速度慢但更好理解
	public int rob2(TreeNode root) {
		return doRob2(root);
	}

	public int doRob2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int include = root.val;
		int exclude = root.left.val + root.right.val;
		if (root.left != null) {
			include = doRob2(root.left.left);
			include = doRob2(root.left.right);
		}
		if (root.right != null) {
			include = doRob2(root.right.left);
			include = doRob2(root.right.right);
		}
		return Math.max(include, exclude);
	}
}
