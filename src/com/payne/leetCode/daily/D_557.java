package com.payne.leetCode.daily;

public class D_557 {

    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * <p>
     * 示例：
     * 输入："Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     * <p>
     * 提示：
     * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public String reverseWords(String s) {

        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len / 2; i++) {
            char t = chars[i];
            chars[i] = chars[len - 1 - i];
            chars[len - 1 - i] = t;
        }
        String reverse = new String(chars);
        String[] s1 = reverse.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (i == 0) {
                sb.append(s1[i]);
            } else {
                sb.append(s1[i]).append(" ");
            }
        }
        return sb.toString();

    }
}
