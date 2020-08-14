package com.payne.leetCode.contest.weekly_114;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_114
 * Date       2018/12/11 - 10:54
 * Author     Payne.
 * About      类描述：
 */

public class P_956_TallestBillboard {

    /**
     * https://leetcode.com/contest/weekly-contest-114/problems/tallest-billboard/
     * <p_old>
     * You are installing a billboard and want it to have the largest height.
     * The billboard will have two steel supports, one on each side.  Each steel support must be an equal height.
     * You have a collection of rods which can be welded together.
     * For example, if you have rods of lengths 1, 2, and 3, you can weld them together to make a support of length 6.
     * Return the largest possible height of your billboard installation.  If you cannot support the billboard, return 0.
     * <p_old>
     * Example 1:
     * Input: [1,2,3,6]
     * Output: 6
     * Explanation: We have two disjoint subsets {1,2,3} and {6}, which have the same sum = 6.
     * <p_old>
     * Note:
     * 0 <= rods.length <= 20
     * 1 <= rods[i] <= 1000
     * The sum of rods is at most 5000.
     */

    public int tallestBillboard(int[] rods) {
        return f1(rods);
    }

    public int f1(int[] rods) {
        int N = rods.length;
        // "memo[n][x]" will be stored at memo[n][5000+x]
        // Using Integer for default value null
        memo = new Integer[N][10001];
        return  dp(rods, 0, 5000);
    }

    int NINF = Integer.MIN_VALUE / 3;
    Integer[][] memo;


    public int dp(int[] rods, int i, int s) {
        if (i == rods.length) {
            return s == 5000 ? 0 : NINF;
        } else if (memo[i][s] != null) {
            return memo[i][s];
        } else {
            int ans = dp(rods, i + 1, s);
            ans = Math.max(ans, dp(rods, i + 1, s - rods[i]));
            ans = Math.max(ans, rods[i] + dp(rods, i + 1, s + rods[i]));
            memo[i][s] = ans;
            return ans;
        }
    }
}
