package com.payne.leetCode.swordOffer;

import com.payne.leetCode.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.swordOffer
 * Date       2020/08/07 - 11:50
 * Author     Payne.
 * About      类描述：
 */

class O_6 {

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * <p_old>
     * <p_old>
     * 示例 1：
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     *  
     * 限制：
     * 0 <= 链表长度 <= 10000
     * <p_old>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //个人推荐使用
    public int[] reversePrint(ListNode head) {
        ListNode tem = head;
        int len = 0;
        while (tem != null) {
            len++;
            tem = tem.next;
        }
        int[] res = new int[len];
        len = 0;
        tem = head;
        while (tem != null) {
            len++;
            res[res.length - len] = tem.val;
            tem = tem.next;
        }
        return res;
    }

    public int[] reversePrint2(ListNode head) {
        ListNode tem = head;
        List<Integer> list = new ArrayList<>();
        while (tem != null) {
            list.add(tem.val);
            tem = tem.next;
        }
        int len = list.size();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[len - 1 - i] = list.get(i);
        }
        return res;
    }


    //官方提供解法(性能并没有比上面两种好。。。）
    public int[] reversePrint3(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }
}
