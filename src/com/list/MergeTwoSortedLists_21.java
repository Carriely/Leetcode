package com.list;
//合并两个有序列表
public class MergeTwoSortedLists_21 {
	//思路1:新建一个链表，依次比较
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(l1 != null && l2 != null) {
        	if(l1.val < l2.val) {
        		temp.next = l1;
        		l1 = l1.next;
        	}else {
        		temp.next = l2;
        		l2 = l2.next;
        	}
        	temp = temp.next;
        }
        temp.next = l1 != null ? l1 : l2;
        return head.next;//？
    }
	//思路2：递归，空间复杂度高O（n）
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
	}
	
}

