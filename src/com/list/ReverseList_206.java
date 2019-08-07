package com.list;

//反转链表
public class ReverseList_206 {
	//遍历算法
	public ListNode reverseList(ListNode head) {
		ListNode result = null;
		while (head != null) {
			ListNode temp = head.next;// 将下一个节点存储起来用作遍历
			head.next = result;// 将当前节点的指针指向前一个节点
			result = head;// 将反转的list赋给result
			head = temp;// head指针后移
		}
		return result;
	}

	// 递归算法
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode reHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return reHead;
	}
}