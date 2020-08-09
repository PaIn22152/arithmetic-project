package com.payne.leetCode.contest.weekly_167;

public class P_5283 {
    /**
     * https://leetcode.com/contest/weekly-contest-167/problems/convert-binary-number-in-a-linked-list-to-integer/
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int getDecimalValue(ListNode head) {
        return byteStr2Int(node2Str(head));
    }

    private String node2Str(ListNode head) {
        ListNode tem = head;
        StringBuilder res = new StringBuilder();
        while (tem != null) {
            res.append(tem.val);
            tem = tem.next;
        }
        return res.toString();
    }

    private int byteStr2Int(String s) {
        return Integer.parseUnsignedInt(s, 2);
    }

}
