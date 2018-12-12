package com.payne.leetCode;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2018/11/07 - 18:20
 * Author     Payne.
 * About      类描述：
 */

public class P_6_ZigZagConversion {

    /**
     * https://leetcode.com/problems/zigzag-conversion/description/
     * <p>
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows
     * like this: (you may want to display this pattern in a fixed font for better legibility)
     * <p>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * <p>
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * <p>
     * <p>
     * <p>
     * P       I      N
     * A     L S    I G
     * Y   A   H   R
     * P d     I f
     * f       f
     */


    public String convert(String s, int numRows) {
        return my(s, numRows);
    }

    public String my(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < numRows; i++) {

            int up = i;
            int down = numRows - 1 - i;
            int upStep = 2 * up;
            int downStep = 2 * down;

            int count = 0;
            int p = i;
            while (p < s.length()) {
                sb.append(chars[p]);
                if (upStep == 0) {
                    p += downStep;
                } else if (downStep == 0) {
                    p += upStep;
                } else {
                    if (count % 2 == 0) {
                        p += downStep;
                    } else {
                        p += upStep;
                    }
                    count++;
                }

            }


        }
        return sb.toString();
    }

    public String convertt(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < numRows; i++) {
            int p = i;
            int upStep = 2 * i;
            int downStep = 2 * (numRows - 1 - i);
            int count = 0;
            while (p < s.length()) {
                sb.append(chars[p]);
                if (upStep == 0) {
                    p += downStep;
                } else if (downStep == 0) {
                    p += upStep;
                } else {
                    if (count % 2 == 0) {
                        p += downStep;
                    } else {
                        p += upStep;
                    }
                    count++;
                }
            }
        }
        return sb.toString();
    }


    public String others(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows - 2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }


}
