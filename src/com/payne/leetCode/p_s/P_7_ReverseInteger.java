package com.payne.leetCode.p_s;


/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2018/08/10 - 11:31
 * Author     Payne.
 * About      类描述：
 */

public class P_7_ReverseInteger {
    /**
     * 7. Reverse Integer
     * DescriptionHintsSubmissionsDiscussSolution
     * Given a 32-bit signed integer, reverse digits of an integer.
     * <p_old>
     * Example 1:
     * <p_old>
     * Input: 123
     * Output: 321
     * Example 2:
     * <p_old>
     * Input: -123
     * Output: -321
     * Example 3:
     * <p_old>
     * Input: 120
     * Output: 21
     * Note:
     * Assume we are dealing with an environment which could only store integers within
     * the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem,
     * assume that your function returns 0 when the reversed integer overflows.
     */

    //用时29min10s
    public int reverse(int x) {
        return my(x);
    }

    public int my(int x) {
        if (x == 0) {
            return 0;
        } else if (x < 0) {
            if (x == Integer.MIN_VALUE) {
                return 0;
            }
            return 0 - my(-x);
        } else {
            String s = "" + x;
            String result = "";
            char[] chars = s.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                System.out.println(chars[i]);
                result += chars[i];
            }
            System.out.println(result);
            int div10 = (int) (Double.parseDouble(result) / 10D);
            int remainder = (int) (Double.parseDouble(result) % 10D);
            if (Integer.MAX_VALUE / 10 < div10) {
                return 0;
            }
            return div10 * 10 + remainder;
        }
    }

    public int sol(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
