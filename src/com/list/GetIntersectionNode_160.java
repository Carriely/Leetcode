package com.list;
//相交链表

//空间复杂度 O(1) 时间复杂度为 O(n)
//思路：
//如果两个链表相交，那么相交点之后的长度是相同的
//所以，让两个链表从距离末尾相同距离的位置开始遍历。这个位置只能是较短链表的头结点位置。
//解法：
//1、指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
//2、如果 pA 到了末尾，则 pA = headB 继续遍历
//3、如果 pB 到了末尾，则 pB = headA 继续遍历
//4、比较长的链表指针指向较短链表head时，长度差就消除了
//5、如此，只需要将最短链表遍历两次即可找到位置

//参考：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
public class GetIntersectionNode_160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode pA = headA;
		ListNode pB = headB;
		while (pA != pB) {
			pA = pA == null ? headB : pA.next;
			pB = pB == null ? headA : pB.next;
		}
		return pA;
	}
}
