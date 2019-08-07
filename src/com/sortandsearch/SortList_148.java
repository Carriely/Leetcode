package com.sortandsearch;

//链表的归并排序，时间复杂度为O(nlogn)，常数级空间复杂度
//解法：
//1）找到链表中点 （快慢指针思路，快指针一次走两步，慢指针一次走一步，快指针在链表末尾时，慢指针恰好在链表中点）；
//2）写出merge函数，即如何合并链表。
//3）写出sortList函数。
public class SortList_148 {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode mid = getMid(head);
		ListNode midNext = mid.next;
		mid.next = null;
		return Merge(sortList(head), sortList(midNext));// ！！！
	}

	// 寻找链表中点
	private ListNode getMid(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {// ！！！
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	// 合并链表
	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		}
		if (list1.val < list2.val) {
			list1.next = Merge(list1.next, list2);
			return list1;
		} else {
			list2.next = Merge(list1, list2.next);
			return list2;
		}
	}
}
