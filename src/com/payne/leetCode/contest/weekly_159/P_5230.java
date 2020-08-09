package com.payne.leetCode.contest.weekly_159;


/**
 * 5230. Check If It Is a Straight Line
 */
public class P_5230 {

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) {
            return true;
        }
        float k = (float) (coordinates[1][1] - coordinates[0][1])
                / (float) (coordinates[1][0] - coordinates[0][0]);
        for (int i = 2; i < coordinates.length; i++) {
            float p = (float) (coordinates[i][1] - coordinates[0][1])
                    / (float) (coordinates[i][0] - coordinates[0][0]);
            if (p != k) {
                return false;
            }
        }
        return true;
    }


}
