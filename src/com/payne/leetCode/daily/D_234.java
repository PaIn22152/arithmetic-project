package com.payne.leetCode.daily;

import com.payne.leetCode.ListNode;

import java.util.Stack;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/10/23 - 09:37
 * Author     Payne.
 * About      类描述：
 */

class D_234 {

    /*https://leetcode-cn.com/problems/palindrome-linked-list/
    * 234. 回文链表
请判断一个链表是否为回文链表。

示例 1:
输入: 1->2
输出: false

示例 2:
输入: 1->2->2->1
输出: true

进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
    * */

    public boolean isPalindrome(ListNode head) {
        ListNode tem = head;
        int len = 0;
        while (tem != null) {
            len++;
            tem = tem.next;
        }
        if (len <= 1) {
            return true;
        }
        boolean even = len % 2 == 0;
        tem = head;
        int p = 0;
        Stack<Integer> stack = new Stack<>();
        while (tem != null) {
            if (p < len / 2) {
                stack.push(tem.val);
            } else {
                if (even) {
                    if (stack.pop() != tem.val) {
                        return false;
                    }
                } else {
                    if (p > len / 2) {
                        if (stack.pop() != tem.val) {
                            return false;
                        }
                    }
                }
            }
            p++;
            tem = tem.next;
        }
        return true;
    }
}
