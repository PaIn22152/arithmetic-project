package com.payne.leetCode.daily;

import com.payne.leetCode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2021/06/04 - 18:20
 * Author     Payne.
 * About      类描述：
 */

public class D_160 {
    //https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode tem = headA;
        while (tem != null) {
            set.add(tem);
            tem = tem.next;
        }
        tem = headB;
        while (tem != null) {
            if (set.contains(tem)) {
                return tem;
            } else {
                tem = tem.next;
            }
        }
        return null;
    }

    //error
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;
        boolean b = true;
        while (t1 != null && t2 != null) {
            if (t1.equals(t2)) {
                return t1;
            } else {
                if (b) {
                    t1 = t1.next;
                } else {
                    t2 = t2.next;
                }
                b = !b;
            }
        }
        return null;
    }


}
