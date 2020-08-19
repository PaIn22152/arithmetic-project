package com.payne.leetCode.daily;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/08/19 - 09:38
 * Author     Payne.
 * About      类描述：
 */

public class D_647 {

    /**
     * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
     * <p>
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     * <p>
     * 示例 1：
     * 输入："abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     * <p>
     * 示例 2：
     * 输入："aaa"
     * 输出：6
     * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
     *  
     * 提示：
     * 输入的字符串长度不会超过 1000 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindromic-substrings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j++) {
                if (isPalindromic(s, i, j)) {
                    ans++;
                }
            }
        }
        return ans + s.length();

    }

    private boolean isPalindromic(String s, int begin, int end) {
        while (end - begin > 1) {
            if (s.charAt(begin) != s.charAt(end - 1)) {
                return false;
            } else {
                begin++;
                end--;
            }
        }

        return true;
    }

    //中心扩散法
    public int countSubstrings2(String s) {
        int ans = 0;
        //奇回文
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    ans++;
                    left--;
                    right++;
                } else {
                    break;
                }

            }
        }
        //偶回文
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i + 1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    ans++;
                    left--;
                    right++;
                } else {
                    break;
                }

            }
        }
        return ans;
    }

    //马拉车算法
    /*
    12 ms
    37.9 MB
    * */
    public int countSubstrings3(String s) {

        //字符串处理  "abc" ->  "^a#b#c$"
        char dec = '#';
        char head = '^';
        char tail = '$';
        StringBuilder sb = new StringBuilder();
        sb.append(head).append(dec);
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                sb.append(s.charAt(i)).append(dec).append(tail);
            } else {
                sb.append(s.charAt(i)).append(dec);
            }
        }
        String newS = sb.toString();

        int[] arr = new int[newS.length() - 2];
        int left;
        int right;
        int v;
        for (int i = 1; i < newS.length() - 1; i++) {
            left = i;
            right = i;
            v = 0;
            while (newS.charAt(left) != head && newS.charAt(right) != tail
                    && newS.charAt(left) == newS.charAt(right)) {
                v++;
                left--;
                right++;
            }
            arr[i - 1] = v;
        }
        int ans = 0;
        for (int i : arr) {
            ans += (i / 2);
        }
        return ans;
    }


    //官方马拉车代码
    /*
    执行用时：3 ms, 在所有 Java 提交中击败了91.69%的用户
    内存消耗：37.7 MB, 在所有 Java 提交中击败了80.50%的用户
    * */
    public int countSubstrings4(String s) {
        int n = s.length();
        StringBuffer t = new StringBuffer("$#");
        for (int i = 0; i < n; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        n = t.length();
        t.append('!');

        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            // 初始化 f[i]
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            // 中心拓展
            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                ++f[i];
            }
            // 动态维护 iMax 和 rMax
            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }
            // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
            ans += f[i] / 2;
        }

        return ans;
    }
    /**
     思考过程
     如果使用暴力求解，遍历所有子串，判断是否满足，时间复杂度会比较大，O(n³)，性能不行

     找到可以去重的可能性，如果某字符串不是回文，那在他左右各加n个字符后的新串，也一定不是回文

     看了下题目相关标签，动态规划，如果使用DP，那么该怎么分解问题呢

     DP 思路
     有时候我们想到了 DP 但想不出来，可以试试这么入手：
     大问题是什么？
     规模小一点的子问题是什么？
     它们之间有什么联系？
     * */
}
