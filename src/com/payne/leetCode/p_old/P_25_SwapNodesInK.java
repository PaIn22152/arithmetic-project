package com.payne.leetCode.p_old;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */
public class P_25_SwapNodesInK {
    public ListNode reverseKGroup(ListNode head, int k) {
        return my(head, k);
    }

    public ListNode my(ListNode head, int k) {

        return null;
    }

    /*public ListNode reverse(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        
    }*/

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
