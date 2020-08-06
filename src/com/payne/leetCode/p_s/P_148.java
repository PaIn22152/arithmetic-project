package com.payne.leetCode.p_s;


import com.payne.leetCode.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.p_s
 * Date       2020/08/06 - 17:18
 * Author     Payne.
 * About      类描述：
 */

class P_148 {

    /**
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     * 示例 1:
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     * <p>
     * 示例 2:
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    //链表转list，list排序，list转链表
    //性能效率不够好
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        ListNode last = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            int v = list.get(i);
            ListNode listNode = new ListNode(v);
            listNode.next = last;
            last = listNode;
        }
        return last;
    }


    //归并排序
    public ListNode sortList2(ListNode head) {

    }
}
