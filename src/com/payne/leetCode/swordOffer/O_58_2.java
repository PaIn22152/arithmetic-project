package com.payne.leetCode.swordOffer;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.swordOffer
 * Date       2020/08/04 - 09:51
 * Author     Payne.
 * About      类描述：
 */

class O_58_2 {

    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     * 示例 2：
     * <p>
     * 输入: s = "lrloseumgh", k = 6
     * 输出: "umghlrlose"
     *  
     * <p>
     * 限制：
     * <p>
     * 1 <= k < s.length <= 10000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public String reverseLeftWords(String s, int n) {
        StringBuilder sbHeader = new StringBuilder();
        StringBuilder sbTail = new StringBuilder();
        int i = 0;
        for (char c : s.toCharArray()) {
            if (i < n) {
                sbTail.append(c);
            } else {
                sbHeader.append(c);
            }
            i++;
        }
        return sbHeader.toString() + sbTail.toString();
    }


    //暂时最优
    public String reverseLeftWords2(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    public String reverseLeftWords3(String s, int n) {
        char[] chars = s.toCharArray();
        int len = s.length();
        return new String(chars, n, len - n) + new String(chars, 0, n);
    }
}
