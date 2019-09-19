package com.list;

//删除链表的倒数第N个节点
public class RemoveNthFromEnd_19 {
	// 方法一：双指针
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n < 1) {
			return null;
		}
		// 添加一个哑结点作为辅助，该结点位于列表头部。
		// 哑结点用来简化某些极端情况，例如列表中只含有一个结点，或需要删除列表的头部。
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode pre = newHead;
		for (int i = 0; i < n + 1; i++) {// 注意n+1次循环
			if (pre.next != null) {
				pre = pre.next;
			}
			return newHead.next;
		}
		ListNode cur = newHead;
		while (pre != null) {
			pre = pre.next;
			cur = cur.next;
		}
		cur.next = cur.next.next;
		return newHead.next;
	}

	// 不使用哑节点，当链表中只有一个节点报错
	public ListNode removeKthFromEnd(ListNode head, int k) {
		if (head == null || k < 1) {
			return null;
		}
		ListNode pre = head;
		for (int i = 0; i < k; i++) {// 注意循环终止条件
			if (pre.next != null) {
				pre = pre.next;
			}
		}
		// 如果 k 的值大于链表长度
		if (pre == null) {
			return null;
		}
		ListNode cur = head;
		while (pre.next != null) {
			cur = cur.next;
			pre = pre.next;
		}
		cur.next = cur.next.next;
		return head;
	}

	// 方法二：遍历两次，删除从列表开头数起的第 (L - n + 1) 个结点
	// L - n + 1 + （n - 1） = L
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		// 添加一个哑结点作为辅助，该结点位于列表头部。
		// 哑结点用来简化某些极端情况，例如列表中只含有一个结点，或需要删除列表的头部。
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		int length = 0;
		ListNode pre = head;
		while (pre != null) {
			length++;
			pre = pre.next;
		}
		pre = newHead;
		length -= n;
		while (length > 0) {
			length--;
			pre = pre.next;
		}
		// 把第 (L - n) 个结点的 next 指针重新链接至第 (L - n + 2) 个结点
		pre.next = pre.next.next;
		return newHead.next;
	}
}
