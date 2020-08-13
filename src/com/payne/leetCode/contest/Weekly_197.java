package com.payne.leetCode.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest
 * Date       2020/08/13 - 16:44
 * Author     Payne.
 * About      类描述：
 */

public class Weekly_197 {

    /**
     * 给你一个整数数组 nums 。
     * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
     * 返回好数对的数目。
     * <p>
     * 示例 1：
     * 输入：nums = [1,2,3,1,1,3]
     * 输出：4
     * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
     * <p>
     * 示例 2：
     * 输入：nums = [1,1,1,1]
     * 输出：6
     * 解释：数组中的每组数字都是好数对
     * <p>
     * 示例 3：
     * 输入：nums = [1,2,3]
     * 输出：0
     * <p>
     * <p>
     * 提示：
     * 1 <= nums.length <= 100
     * 1 <= nums[i] <= 100
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-good-pairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    ans++;
                }
            }
        }
        return ans;

    }


    /**
     * 给你一个二进制字符串 s（仅由 '0' 和 '1' 组成的字符串）。
     * 返回所有字符都为 1 的子字符串的数目。
     * 由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
     * <p>
     * 示例 1：
     * 输入：s = "0110111"
     * 输出：9
     * 解释：共有 9 个子字符串仅由 '1' 组成
     * "1" -> 5 次
     * "11" -> 3 次
     * "111" -> 1 次
     * <p>
     * 示例 2：
     * 输入：s = "101"
     * 输出：2
     * 解释：子字符串 "1" 在 s 中共出现 2 次
     * <p>
     * 示例 3：
     * 输入：s = "111111"
     * 输出：21
     * 解释：每个子字符串都仅由 '1' 组成
     * <p>
     * 示例 4：
     * 输入：s = "000"
     * 输出：0
     *  
     * 提示：
     * s[i] == '0' 或 s[i] == '1'
     * 1 <= s.length <= 10^5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-substrings-with-only-1s
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    private static final int MOD = 1000000007;

    public int numSub(String s) {
        List<Integer> list = new ArrayList<>();
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                len++;
            } else {
                if (len > 0) {
                    list.add(len);
                    len = 0;
                }
            }
        }
        if (len > 0) {
            list.add(len);
        }
        int ans = 0;
        for (int i : list) {
            ans = (ans + sub(i));
            ans = ans % MOD;
        }
        return ans;
    }

    private int sub(int i) {
        int tem = 0;
        for (int j = 0; j < i; j++) {
            tem += (j + 1);
            tem = tem % MOD;
        }
        return tem;
    }



    /**
     https://leetcode-cn.com/problems/path-with-maximum-probability/
     * */
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

    }

}
