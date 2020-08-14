package com.payne.leetCode.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.interview
 * Date       2020/08/04 - 10:19
 * Author     Payne.
 * About      类描述：
 */

public class Random1 {

    /**
     * 随机模拟面试
     * */

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     * <p_old>
     * <p_old>
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p_old>
     * <p_old>
     * <p_old>
     * 示例：
     * <p_old>
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = curNode(l1, l2);
        return res;
    }

    private ListNode curNode(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        int val;
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            res.val = l2.val;
            res.next = l2.next;
        } else if (l2 == null) {
            res.val = l1.val;
            res.next = l1.next;
        } else {
            if (l1.val <= l2.val) {
                val = l1.val;
                l1 = l1.next;
            } else {
                val = l2.val;
                l2 = l2.next;
            }
            res.val = val;
            res.next = curNode(l1, l2);
        }
        return res;
    }


    /**
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     * <p_old>
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     * <p_old>
     * 注意:
     * 假设字符串的长度不会超过 1010。
     * <p_old>
     * 示例 1:
     * <p_old>
     * 输入:
     * "abccccdd"
     * <p_old>
     * 输出:
     * 7
     * <p_old>
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     */
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                int n = map.get(c) + 1;
                map.put(c, n);
            } else {
                map.put(c, 1);
            }
        }
        int num = 0;
        boolean haveOdd = false;
        for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            int n = entry.getValue();
            if (n % 2 == 0) {
                num += n;
            } else {
                num += (n - 1);
                haveOdd = true;
            }
        }
        return num + (haveOdd ? 1 : 0);
    }


    /**
     * 我们有一系列公交路线。每一条路线 routes[i] 上都有一辆公交车在上面循环行驶。
     * 例如，有一条路线 routes[0] = [1, 5, 7]，
     * 表示第一辆 (下标为0) 公交车会一直按照 1->5->7->1->5->7->1->... 的车站路线行驶。
     * <p_old>
     * 假设我们从 S 车站开始（初始时不在公交车上），要去往 T 站。
     * 期间仅可乘坐公交车，求出最少乘坐的公交车数量。返回 -1 表示不可能到达终点车站。
     * <p_old>
     * 示例：
     * 输入：
     * routes = [[1, 2, 7], [3, 6, 7]]
     * S = 1
     * T = 6
     * 输出：2
     * 解释：
     * 最优策略是先乘坐第一辆公交车到达车站 7, 然后换乘第二辆公交车到车站 6。
     * <p_old>
     * 提示：
     * 1 <= routes.length <= 500.
     * 1 <= routes[i].length <= 10^5.
     * 0 <= routes[i][j] < 10 ^ 6.
     */

    //宽度优先
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }
        Set<Integer> start = new HashSet<>();
        start.add(S);

        Set<Integer> history = new HashSet<>();
        history.add(S);

        int num = 0;
        List<Set<Integer>> r = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
            Set<Integer> s = new HashSet<>();
            for (int j = 0; j < routes[i].length; j++) {
                s.add(routes[i][j]);
            }
            r.add(s);
        }
        while (true) {
            num++;
            if (num > routes.length) {
                return -1;
            }
            Set<Integer> reach = reach2(r, start, history);
//            Set<Integer> reach = reach(routes, start, history);
            if (reach.size() == 0) {
                return -1;
            }
            if (reach.contains(T)) {
                return num;
            } else {
                start.clear();
                start.addAll(reach);
                history.addAll(reach);
            }
        }

    }

    private Set<Integer> reach2(List<Set<Integer>> routes, Set<Integer> start, Set<Integer> history) {
        Set<Integer> res = new HashSet<>();
        for (int i : start) {
            for (int j = 0; j < routes.size(); j++) {
                if (routes.get(j).contains(i)) {
                    for (int v : routes.get(j)) {
                        if (!history.contains(v)) {
                            res.add(v);
                        }
                    }
                }
            }
        }
        return res;

    }

    private Set<Integer> reach(int[][] routes, Set<Integer> start, Set<Integer> history) {
        Set<Integer> res = new HashSet<>();
        for (int i : start) {
            for (int j = 0; j < routes.length; j++) {
                boolean canReach = false;
                for (int k = 0; k < routes[j].length; k++) {
                    int v = routes[j][k];
                    if (v == i) {
                        canReach = true;
                        break;
                    }
                }
                if (canReach) {
                    for (int k = 0; k < routes[j].length; k++) {
                        int v = routes[j][k];
                        if (!history.contains(v)) {
                            res.add(v);
                        }
                    }
                }
            }
        }
        return res;
    }
}
