package com.payne.leetCode.daily;

public class D_214 {

    /**
     * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。
     * 找到并返回可以用这种方式转换的最短回文串。
     * <p>
     * 示例 1:
     * 输入: "aacecaaa"
     * 输出: "aaacecaaa"
     * <p>
     * 示例 2:
     * 输入: "abcd"
     * 输出: "dcbabcd"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shortest-palindrome
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public String shortestPalindrome(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i > 1; i--) {
            boolean b = false;
            for (int j = 0; j < i / 2; j++) {
                if (s.charAt(j) != s.charAt(i - 1 - j)) {
                    b = false;
                    break;
                } else {
                    b = true;
                }
            }
            if (b) {
                break;
            } else {
                sb.append(s.charAt(i - 1));
            }
        }
        sb.append(s);
        return sb.toString();

    }


}
