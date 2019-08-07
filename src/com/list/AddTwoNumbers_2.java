package com.list;

//两数相加
public class AddTwoNumbers_2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode newHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = newHead;
		// 进位
		int carry = 0;
		while (p != null || q != null) {
			int x = p != null ? p.val : 0;
			int y = q != null ? q.val : 0;
			int sum = x + y + carry;
			// 更新进位
			carry = sum / 10;
			// 取模运算计算对应位之和
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		// 是否还有进位
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return newHead.next;
	}

}
