package com.payne.leetCode.daily;

import com.payne.leetCode.ListNode;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/10/20 - 10:13
 * Author     Payne.
 * About      类描述：
 */

class D_143 {

    /*https://leetcode-cn.com/problems/reorder-list/
    * 143. 重排链表
给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:
给定链表 1->2->3->4, 重新排列为 1->4->2->3.
示例 2:
给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
    * */


    //解法1，超时
    public void reorderList(ListNode head) {
        ListNode tem = head;
        while (tem != null) {
            tem.next = reverse(tem.next);
            tem = tem.next;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tem = head;
        ListNode last = null;
        while (tem != null) {
            ListNode t = new ListNode(tem.val);
            t.next = last;
            last = t;
            tem = tem.next;
        }
        return last;
    }


    public void reorderList2(ListNode head) {
        ListNode t = head;
        int len = 0;
        while (t != null) {
            len++;
            t = t.next;
        }
        handle(head, head, 0, len, -1);
    }

    private void handle(ListNode head, ListNode cur, int left, int right, int tag) {
        if (cur != null) {
            if (tag < 0) {
                cur.next = getPosition(head, left + 1);
                handle(head, cur.next, left + 1, right, tag * -1);
            } else {
                cur.next = getPosition(head, right - 1);
                handle(head, cur.next, left, right - 1, tag * -1);
            }
        }
    }

    private ListNode getPosition(ListNode head, int index) {
        ListNode t = head;
        while (t != null) {
            if (index == 0) {
                return t;
            }
            index--;
            t = t.next;
        }
        return null;
    }


    //递归
    /*
    执行用时：533 ms, 在所有 Java 提交中击败了5.14%的用户
    内存消耗：42 MB, 在所有 Java 提交中击败了26.31%的用户
    * */
    public void reorderList3(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode temp = head;
        while (temp.next.next != null)
            temp = temp.next;
        temp.next.next = head.next;
        head.next = temp.next;
        temp.next = null;
        reorderList3(head.next.next);
    }


    //官方代码
    public void reorderList4(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}
