package com.payne.leetCode.p_s;

/**
 * Created by payne on 2017-12-19.
 * About 类描述：
 */
public class P_2_AddTwoNumbers {

    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * Example
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     * <p_old>
     * [2,4,3]
     * [5,6,4]
     */

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode tem = pre;
        int tag = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + tag;
            tag = sum / 10;
            sum %= 10;

            tem.next = new ListNode(sum);
            tem = tem.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (tag > 0) {
            tem.next = new ListNode(tag);
        }
        return pre.next;
    }


    /**
     * //递归
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.99%的用户
     * <p>
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了67.33%的用户
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return addTwoNumbers2(l1, l2, false);
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2, boolean add1) {
        int val;
        if (l1 == null && l2 == null) {
            if (add1) {
                return new ListNode(1);
            } else {
                return null;
            }
        } else if (l1 == null) {
            val = l2.val + (add1 ? 1 : 0);
        } else if (l2 == null) {
            val = l1.val + (add1 ? 1 : 0);
        } else {
            val = l1.val + l2.val + (add1 ? 1 : 0);
        }
        add1 = val >= 10;
        val = val % 10;
        ListNode res = new ListNode(val);
        res.next = addTwoNumbers2(l1 == null ? null : l1.next, l2 == null ? null : l2.next, add1);
        return res;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(0, l1, l2);
    }

    private static int startDeep = 0;

    public static ListNode addTwoNumbers(int addNum, ListNode node1, ListNode node2) {

        if (addNum > 0) {
            ListNode listNode = new ListNode(addNum);
            if (node1 == null && node2 == null) {
                return listNode;
            } else if (node1 != null && node2 == null) {
                return addTwoNumbers(0, listNode, node1);
            } else if (node2 != null && node1 == null) {
                return addTwoNumbers(0, listNode, node2);
            }
        }

        ListNode result = null;
        if (startDeep == 0) {
            int deep1 = getDeep(node1);
            int deep2 = getDeep(node2);
            int deep = deep1 > deep2 ? deep1 : deep2;
            startDeep = deep;
        } else {
            startDeep -= 1;
        }

        for (int i = 0; i < startDeep; i++) {
            int sum;
            if (node1 != null && node2 != null) {
                sum = node1.val + node2.val + addNum;
            } else if (node1 == null && node2 != null) {
                sum = node2.val + addNum;
            } else if (node1 != null && node2 == null) {
                sum = node1.val + addNum;
            } else {
                sum = addNum;
            }
            addNum = sum / 10;
            if (result == null) {
                result = new ListNode(sum % 10);
            }
            result.next = addTwoNumbers(addNum, node1 == null ? null : node1.next,
                    node2 == null ? null : node2.next);
        }
        return result;

    }

    public static int reverseInt(int i) {
        String s = i + "";
        String result = "";
        for (int j = s.length() - 1; j >= 0; j--) {
            result += s.charAt(j);
        }
        return Integer.parseInt(result);
    }

    public static ListNode getListNodeByInt(int i, ListNode node) {
        if (node == null) {
            i = reverseInt(i);
        }
        if (i > 0 && i / 10 >= 0) {
            ListNode list = new ListNode(i % 10);
            list.next = node;
            node = getListNodeByInt(i / 10, list);
        }
        return node;

    }


    public static int getDeep(ListNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getDeep(node.next);
    }

    public static ListNode getDeepNode(int deep, ListNode node) {
        if (deep >= getDeep(node)) {
            return null;
        }
        if (deep == 0) {
            return node;
        } else {
            return getDeepNode(deep - 1, node.next);
        }
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + ((next == null) ? "null" : next.toString()) +
                    '}';
        }
    }

}
