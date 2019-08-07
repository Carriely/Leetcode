package com.sortandsearch;

//链表的插入排序
public class InsertionSortList2 {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// pre指向已经有序的节点
		ListNode pre = head;
		// cur指向待排序的节点
		ListNode cur = head.next;
		ListNode aux = new ListNode(Integer.MIN_VALUE);// 辅助节点
		aux.next = head;
		while (cur != null) {
			if (cur.val < pre.val) {
				// 先把cur节点从当前链表中删除，然后再把cur节点插入到合适位置
				pre.next = cur.next;

				// 从前往后找到l2.val>cur.val,然后把cur节点插入到l1和l2之间
				ListNode l1 = aux;
				ListNode l2 = aux.next;
				while (cur.val > l2.val) {
					l1 = l2;
					l2 = l2.next;
				}
				// 把cur节点插入到l1和l2之间
				l1.next = cur;
				cur.next = l2;

				// 指向下一个待处理节点
				cur = pre.next;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		return aux.next;
	}
}
