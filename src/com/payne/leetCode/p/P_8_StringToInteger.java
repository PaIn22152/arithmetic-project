package com.payne.leetCode.p;

import java.util.regex.Pattern;

/**
 * Created by payne on 2017-12-20.
 * About 类描述：
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not
 * see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
 * You are responsible to gather all the input requirements up front.
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your
 * function signature accepts a const char * argument, please click the reload button
 * to reset your code definition.
 */
public class P_8_StringToInteger {

    public static int myAtoi(String str) {
        try {
            str = str.trim();
            char[] chars = str.toCharArray();
            String result = "";
            boolean haveNum = false;
            boolean haveOp = false;
            for (char c : chars) {
                if (isNumber(c)) {
                    result += c;
                    haveNum = true;
                } else {
                    if (haveNum) {
                        return Integer.parseInt(result);
                    }
                }
                if (!haveOp) {
                    if (isOperator(c)) {
                        result += c;
                        haveOp = true;
                    }
                }

            }
            System.out.println(" result = " + result);
            return Integer.parseInt(result);
        } catch (Exception e) {
            return 0;
        }
    }


    public static boolean isMatch(final String regex, final CharSequence input) {
        return input != null && input.length() > 0 && Pattern.matches(regex, input);
    }

    public static boolean isOperator(char c) {
        String regex = "\\+|\\-|\\*|\\/";
        char[] cs = new char[1];
        cs[0] = c;
        return isMatch(regex, new String(cs));

    }

    public static boolean isNumber(char c) {
        String regex = "[0-9]";
        char[] cs = new char[1];
        cs[0] = c;
        return isMatch(regex, new String(cs));
    }

    private static String delZero(String s) {
        boolean minus = false;
        if (s.startsWith("-")) {
            s = s.substring(1);
            minus = true;
        }
        if (s.length() == 1) {
            return minus ? "-" + s : s;
        }
        if (s.startsWith("0")) {
            return delZero(minus ? "-" + s.substring(1) : s.substring(1));
        } else {
            return minus ? "-" + s : s;
        }
    }

    //"+1"=1
    //"   +0 123"=0
    //"2147483648"=2147483647
    //"  0000000000012345678"=12345678
    //"-000000000000001"=-1
    //"-2147483647"=-2147483647
    //"-91283472332"=-2147483648
    public static int myAtoi2(String str) {
        str = str.trim();
        String res = "";
        boolean first = true;
        for (char c : str.toCharArray()) {
            if (c == '-') {
                if (first) {
                    res += c;
                    first = false;
                } else {
                    break;
                }

            } else if (c == '+') {
                if (first) {
                    first = false;
                } else {
                    break;
                }
            } else if (isNumber2(c)) {
                first = false;
                res += c;
            } else {
                break;
            }
        }
        try {
            res = delZero(res);
            if (res.startsWith("-") && res.length() > 12) {
                return Integer.MIN_VALUE;
            } else if (!res.startsWith("-") && res.length() > 11) {
                return Integer.MAX_VALUE;
            }
            long l = Long.parseLong(res);
            if (l - Integer.MAX_VALUE > 0) {
                return Integer.MAX_VALUE;
            }
            if (l - Integer.MIN_VALUE < 0) {
                return Integer.MIN_VALUE;
            }
            return (int) l;
        } catch (Exception e) {
            return 0;
        }

    }


    public static boolean isNumber2(char c) {
        return '0' == c || '1' == c || '2' == c || '3' == c || '4' == c || '5' == c || '6' == c || '7' == c || '8' == c || '9' == c;
    }

}
