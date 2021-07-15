package com.payne.leetCode.p_s;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2019/02/19 - 17:29
 * Author     Payne.
 * About      类描述：
 */

public class P_62 {

    /**
     * https://leetcode.com/problems/unique-paths/
     */

    //2021-02-26
    //动态规划
    //方程
    public int uniquePaths4(int m, int n) {

        return 0;
    }

    private int ans = 0;

    public int uniquePaths(int m, int n) {
//        int x = 1;
//        int y = 1;
//        if (m == 1 && n == 1) {
//            return 1;
//        }
//        dfs(x, y, m, n);
//        return ans;

//        return dp(m,n);

        return uniquePaths3(m, n);

    }


    public int uniquePaths2(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if (m < n) {              // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for (int i = m + 1; i <= m + n; i++, j++) {
            // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }

        return (int) res;
    }

    // 数学公式
    public int uniquePaths3(int m, int n) {
        int N = n + m - 2;// how much steps we need to do
        int k = m - 1; // number of steps that need to go down
        double res = 1;
        // here we calculate the total possible path number
        // Combination(N, k) = n! / (k!(n - k)!)
        // reduce the numerator and denominator and get
        // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
        for (int i = 1; i <= k; i++)
            res = res * (N - k + i) / i;
        return (int) res;
    }

    //Dynamic programming 动态规划
    public int dp(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    grid[i][j] = 1;
                else
                    grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
            }
        }
        return grid[m - 1][n - 1];
    }

    //Depth-First-Search 深度优先
    private void dfs(int x, int y, int m, int n) {
        if (x + 1 == m) {
            ans += (n - y + 1);
            return;
        }
        if (y + 1 == n) {
            ans += (m - x + 1);
            return;
        }
        if (x < m) {
            dfs(x + 1, y, m, n);
        }
        if (y < n) {
            dfs(x, y + 1, m, n);
        }
    }

}
