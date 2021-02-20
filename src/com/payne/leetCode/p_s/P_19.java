package com.payne.leetCode.p_s;

import com.payne.leetCode.ListNode;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.p_s
 * Date       2021/02/20 - 15:15
 * Author     Payne.
 * About      类描述：
 */

class P_19 {

    /**
     * 19. 删除链表的倒数第 N 个结点
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * <p>
     * 进阶：你能尝试使用一趟扫描实现吗？
     * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode right = pre;
        ListNode left = pre;
        for (int i = 0; i <= n; i++) {
            right = right.next;
        }
        while (right != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return pre.next;
    }
}
