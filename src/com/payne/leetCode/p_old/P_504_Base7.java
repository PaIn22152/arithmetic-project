package com.payne.leetCode.p_old;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2018/08/10 - 11:11
 * Author     Payne.
 * About      类描述：
 */

public class P_504_Base7 {
    /**
     * Given an integer, return its base 7 string representation.
     * <p_old>
     * Example 1:
     * Input: 100
     * Output: "202"
     * Example 2:
     * Input: -7
     * Output: "-10"
     * Note: The input will be in range of [-1e7, 1e7].
     */

    //用时16min21s
    public String convertToBase7(int num) {
        return my(num);
    }

    public String my(int num) {
        if (num == 0) {
            return "0";
        } else if (num > 0) {
            StringBuilder result = new StringBuilder();
            while (num / 7 >= 1) {
                result.insert(0, (num % 7));
                num /= 7;
            }
            result.insert(0, (num % 7));
            return result.toString();
        } else {
            return "-" + my(-num);
        }

    }
}
