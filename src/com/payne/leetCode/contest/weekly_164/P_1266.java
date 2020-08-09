package com.payne.leetCode.contest.weekly_164;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_164
 * Date       2019/11/26 - 15:02
 * Author     Payne.
 * About      类描述：
 */

public class P_1266 {
    /**
     * https://leetcode.com/contest/weekly-contest-164/problems/minimum-time-visiting-all-points/
     */

    public int minTimeToVisitAllPoints(int[][] points) {
        int t = 0;
        for (int i = 0; i < points.length - 1; i++) {
            t += getTwoPointVisitTime(points[i][0], points[i][1],
                    points[i + 1][0], points[i + 1][1]);
        }
        return t;
    }

    private int getTwoPointVisitTime(int x1, int y1, int x2, int y2) {
        int t1 = Math.abs(x1 - x2);
        int t2 = Math.abs(y1 - y2);
        return t1 > t2 ? t1 : t2;
    }
}
