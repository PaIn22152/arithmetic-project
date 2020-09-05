package com.payne.leetCode.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/09/02 - 09:46
 * Author     Payne.
 * About      类描述：
 */

public class D_O_20 {

    /**
     * 剑指 Offer 20. 表示数值的字符串
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
     * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
     * <p>
     * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
     */


    public boolean isNumber(String s) {
        s = s.trim();
        //把可能出现的'E'转成'e'
        s = s.toLowerCase();

        //去掉头部的正负号
        if (s.startsWith("+") || s.startsWith("-")) {
            s = s.substring(1);
        }


        int dot = -1;//出现小数点的位置
        int e = -1;//出现e的位置
        int minus = -1;//出现-的位置
        int plus = -1;//出现+的位置
        boolean haveDigit = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //记录下是否有数字
            if (Character.isDigit(c)) {
                haveDigit = true;
            }

            //如果出现正号，判断e是否在正号前一位，不是就返回false
            //然后判断正号是否出现过，如果出现过，返回false
            //判断是否在尾部，如果是，返回false
            else if (c == '+') {
                if (e == -1 || i - 1 != e) {
                    return false;
                }
                if (plus != -1) {
                    return false;
                }
                if (i == s.length() - 1) {
                    return false;
                }
                plus = i;
            }

            //如果出现负号，判断e是否在负号前一位，不是就返回false
            //然后判断负号是否出现过，如果出现过，返回false
            //判断是否在尾部，如果是，返回false
            else if (c == '-') {
                if (e == -1 || i - 1 != e) {
                    return false;
                }
                if (minus != -1) {
                    return false;
                }
                if (i == s.length() - 1) {
                    return false;
                }
                minus = i;
            }

            //如果出现e，判断在e之前，是否有数字，如果没有，返回false
            // 然后判断当前位置是否是尾部，如果是，返回false
            // 然后判断是否出现过，如果已经出现过e，返回false，否则记录下位置
            else if (c == 'e') {
                if (!haveDigit) {
                    return false;
                }
                if (i == s.length() - 1) {
                    return false;
                }
                if (e != -1) {
                    return false;
                }
                e = i;
            }

            //如果出现小数点，判断是否在e之后，如果是，返回false
            // 然后判断是否出现过，出现过返回false
            //否则记录下当前位置
            else if (c == '.') {
                if (e != -1) {
                    return false;
                }
                if (dot != -1) {
                    return false;
                }
                dot = i;
            }
            //出现其他字符，返回false
            else {
                return false;
            }
        }
        return haveDigit;

    }

    /**
     思考过程
     首先要确定的是，什么样的字符串可以表示数字
     1.全是由0-9组成的字符串  234
     2.在1的中间，加上一个小数点  2.34
     3.2+e（或者E）+1（带正负号的1）  2.34e-23
     4.在1,2,3的前面，加上正负号  -2.34e-23
     * */
}
