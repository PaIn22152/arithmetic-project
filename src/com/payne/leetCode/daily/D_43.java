package com.payne.leetCode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/08/13 - 09:30
 * Author     Payne.
 * About      类描述：
 */

public class D_43 {

    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，
     * 返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * <p_old>
     * 示例 1:
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * <p_old>
     * 示例 2:
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     * <p_old>
     * 说明：
     * num1 和 num2 的长度小于110。
     * num1 和 num2 只包含数字 0-9。
     * num1 和 num2 均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     * <p_old>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/multiply-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    /**
     * 解题思路
     * 把乘法转成加法
     * 比如  32*123
     * 转成 123 + 123 + 1230 + 1230 + 1230
     * 然后对所有string进行相加
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        List<String> list = new ArrayList<>();
        String zero = "";
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = 0; j < num1.charAt(i) - '0'; j++) {
                list.add(num2 + zero);
            }
            zero += "0";
        }
        int maxLen = num2.length() + zero.length() - 1;
        String s = add(list, maxLen, 0);
        return delZero(s);
    }

    /**
     * 把乘法转成加法
     * 两两相加
     * */
    public String multiply3(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String zero = "";
        String ans = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = 0; j < num1.charAt(i) - '0'; j++) {
                ans = add(ans, num2 + zero);
            }
            zero += "0";
        }
        return delZero(ans);
    }

    private String add(String s1, String s2) {
        int len = Math.max(s1.length(), s2.length());
        boolean add1 = false;
        String s = "";

        for (int i = 0; i < len; i++) {
            int res = 0;
            int p1 = s1.length() - 1 - i;
            if (p1 < s1.length() && p1 >= 0) {
                res += (s1.charAt(p1) - '0');
            }

            int p2 = s2.length() - 1 - i;
            if (p2 < s2.length() && p2 >= 0) {
                res += (s2.charAt(p2) - '0');
            }
            if (add1) {
                res++;
            }
            add1 = res >= 10;
            s = (res % 10) + s;
        }
        if (add1) {
            return "1" + s;
        }
        return s;
    }

    private String delZero(String s) {
        if (s.length() == 1) {
            return s;
        }
        if (s.startsWith("0")) {
            return delZero(s.substring(1));
        }
        return s;
    }

    /**
     * 字符串相加
     * 递归，先相加所有字符串最后一位，得到结果的最后一位，然后依次计算上一位
     */
    public String add(List<String> list, int maxLen, int index) {
        if (index == maxLen) {
            return "";
        }
        int res = 0;
        for (String s : list) {
            int p = s.length() - 1 - index;
            if (p < s.length() && p >= 0) {
                res += (s.charAt(p) - '0');
            }
        }

        String s = "" + res;
        int tail = res % 10;
        for (int i = 0; i < index; i++) {
            s += "0";
        }
        list.add(s);
        return add(list, Math.max(s.length(), maxLen), index + 1) + tail;
    }


    //官方代码
    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuffer curr = new StringBuffer();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }


}
