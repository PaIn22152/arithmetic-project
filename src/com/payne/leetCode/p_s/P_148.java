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

public class P_148 {

    /**
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     * 示例 1:
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     * <p_old>
     * 示例 2:
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     * <p_old>
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





    //
    public List<Integer> sort(List<Integer> list) {
        if (list == null || list.size() == 1) {
            return list;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() / 2) {
                left.add(list.get(i));
            } else {
                right.add(list.get(i));
            }
        }
        return merge(sort(left), sort(right));
    }

    public List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        int p1 = 0, p2 = 0;
        List<Integer> mer = new ArrayList<>();
        while (p1 < l1.size() || p2 < l2.size()) {
            if (p1 < l1.size() && p2 < l2.size()) {
                if (l1.get(p1) < l2.get(p2)) {
                    mer.add(l1.get(p1));
                    p1++;
                } else {
                    mer.add(l2.get(p2));
                    p2++;
                }
            } else if (p1 < l1.size()) {
                mer.add(l1.get(p1));
                p1++;
            } else if (p2 < l2.size()) {
                mer.add(l2.get(p2));
                p2++;
            }
        }
        return mer;
    }


    //归并排序
    public int[] sortArray(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int[] left = new int[nums.length / 2];
        int[] right = new int[nums.length - nums.length / 2];
        int pl = 0;
        int pr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length / 2) {
                left[pl++] = nums[i];
            } else {
                right[pr++] = nums[i];
            }
        }
        return merge2(sortArray(left), sortArray(right));
    }


    public int[] merge2(int[] l1, int[] l2) {
        int p1 = 0, p2 = 0;
        int[] mer = new int[l1.length + l2.length];
        int p = 0;
        while (p1 < l1.length || p2 < l2.length) {
            if (p1 < l1.length && p2 < l2.length) {
                if (l1[p1] < l2[p2]) {
                    mer[p++] = l1[p1];
                    p1++;
                } else {
                    mer[p++] = l2[p2];
                    p2++;
                }
            } else if (p1 < l1.length) {
                mer[p++] = l1[p1];
                p1++;
            } else if (p2 < l2.length) {
                mer[p++] = l2[p2];
                p2++;
            }
        }
        return mer;
    }
}
