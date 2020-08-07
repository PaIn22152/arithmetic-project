package com.payne.leetCode.swordOffer;

import com.payne.leetCode.ListNode;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.swordOffer
 * Date       2020/08/07 - 12:01
 * Author     Payne.
 * About      类描述：
 */

class O_24 {

    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     * <p>
     * 示例:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     *  
     * 限制：
     * 0 <= 节点个数 <= 5000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //没有看懂
        ListNode tem = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tem;
    }


    public ListNode reverseList2(ListNode head) {
        ListNode l1 = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tem = new ListNode(curr.val);
            tem.next = l1;
            l1 = tem;
            curr = curr.next;
        }
        return l1;
    }
}
