package com.payne.leetCode.p_s;

import com.payne.leetCode.ListNode;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.p_s
 * Date       2021/02/20 - 18:03
 * Author     Payne.
 * About      类描述：
 */

class P_61 {

    /**
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     * 示例 1:
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     * 解释:
     * 向右旋转 1 步: 5->1->2->3->4->NULL
     * 向右旋转 2 步: 4->5->1->2->3->NULL
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    // 1 -> 2 -> 3
    //思路，把单链表转成环，然后再合适的地方解环
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode t = head;
        int len = 1;
        while (t.next != null) {
            t = t.next;
            len++;
        }
        t.next = head;

        k = len - k % len;
        ListNode t2 = head;//新的链尾，t2的next才是新的head，所以要-1
        for (int i = 0; i < k - 1; i++) {
            t2 = t2.next;
        }
        ListNode ans = t2.next;
        t2.next = null;
        return ans;
    }
}
