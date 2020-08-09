package com.payne.leetCode.p_s;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2018/08/23 - 11:41
 * Author     Payne.
 * About      类描述：
 */

public class P_402_RemoveKDigits {
    /**
     * https://leetcode.com/problems/remove-k-digits/description/
     * <p>
     * Given a non-negative integer num represented as a string, remove k digits from the number
     * so that the new number is the smallest possible.
     * <p>
     * Note:
     * The length of num is less than 10002 and will be ≥ k.
     * The given num does not contain any leading zero.
     * Example 1:
     * <p>
     * Input: num = "1432219", k = 3
     * Output: "1219"
     * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
     * Example 2:
     * <p>
     * Input: num = "10200", k = 1
     * Output: "200"
     * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
     * Example 3:
     * <p>
     * Input: num = "10", k = 2
     * Output: "0"
     * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
     * <p>
     * intput   142566   2
     * output   1256
     */

    //用时49min15s
    public String removeKdigits(String num, int k) {
        return my(num, k);

    }

    private  int point = 0;

    public String my(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        int p = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num.length() - k; i++) {
            String s = num.substring(p, k + 1 + i);
            result.append(getMin(s));
            p++;
            p += point;
        }
        return delHeadZero(result.toString());
    }

    private String delHeadZero(String s) {
        if ("".equals(s)) {
            return "0";
        } else if (s.startsWith("0")) {
            boolean end = false;
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (!end && '0' != c) {
                    end = true;
                }
                if (end) {
                    sb.append(c);
                }
            }
            if ("".equals(sb.toString())) {
                return "0";
            } else
                return sb.toString();
        }
        return s;

    }

    private String getMin(String s) {
        int min = Integer.MAX_VALUE;
        for (char c : s.toCharArray()) {
            int temp = Integer.parseInt(String.valueOf(c));
            min = Integer.min(min, temp);
        }
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.toCharArray()[i];
            int temp = Integer.parseInt(String.valueOf(c));
            if (temp == min) {
                point = i;
                break;
            }
        }
        return min + "";
    }
}
