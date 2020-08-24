package com.payne.leetCode.p_s;

import com.payne.leetCode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.p_s
 * Date       2020/08/14 - 17:01
 * Author     Payne.
 * About      类描述：
 */

class P_234 {

    /**
     * 请判断一个链表是否为回文链表。
     * <p>
     * 示例 1:
     * 输入: 1->2
     * 输出: false
     * <p>
     * 示例 2:
     * 输入: 1->2->2->1
     * 输出: true
     * <p>
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

//    public boolean isPalindrome(ListNode head) {
//        ListNode left = head, right = head;
//        while (right != null) {
//            if (right.next != null) {
//                right = right.next.next;
//                left = left.next;
//            } else {
//                break;
//            }
//        }
//
//    }
    public boolean isPalindrome2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode tem = head;
        while (tem != null) {
            list.add(tem.val);
            tem = tem.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }



}
