package com.payne.leetCode.p;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class P_24_SwapNodes {
    public ListNode swapPairs(ListNode head) {
        return my(head);
    }

    public ListNode my(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            int n = head.val;
            head.val = head.next.val;
            head.next.val = n;
            head.next.next = my(head.next.next);
            return head;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
