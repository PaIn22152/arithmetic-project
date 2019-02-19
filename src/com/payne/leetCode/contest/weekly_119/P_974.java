package com.payne.leetCode.contest.weekly_119;

import com.payne.utils.PrintHelper;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_119
 * Date       2019/01/14 - 14:24
 * Author     Payne.
 * About      类描述：
 */

public class P_974 {

    /**
     * https://leetcode.com/contest/weekly-contest-119/problems/subarray-sums-divisible-by-k/
     */

    public int subarraysDivByK(int[] A, int K) {
        int[] count = new int[K];
        int n = A.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        count[0] = 1;

        int curSum = 0;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            curSum += A[i - 1];
            int r = (curSum % K + K) % K;
            ans += count[r];

            count[r]++;
        }

        return ans;
    }

    public int sub2(int[] A, int K) {
        int N = A.length;
        int[] P = new int[N + 1];
        for (int i = 0; i < N; i++)
            P[i + 1] = P[i] + A[i];

        int[] count = new int[K];
        for (int x : P)
            count[(x % K + K) % K]++;

        int ans = 0;
        for (int v : count)
            ans += v * (v - 1) / 2;
        return ans;
    }

    public int mod(int a, int b) {
        PrintHelper.println(-7/4);
        PrintHelper.println(-7%4);
        PrintHelper.println(7/-4);
        PrintHelper.println(7%-4);
        PrintHelper.println((7 % -4 + -4) % -4);
        PrintHelper.println(Math.floorMod(7, -4));
        return 0;
    }

}
