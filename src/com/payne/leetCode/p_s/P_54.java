package com.payne.leetCode.p_s;

import java.util.ArrayList;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2019/02/20 - 11:12
 * Author     Payne.
 * About      类描述：
 */

public class P_54 {

    /**
     * https://leetcode.com/problems/spiral-matrix/
     */

    private List<Integer> ans;

    public List<Integer> spiralOrder(int[][] matrix) {
        ans = new ArrayList<>();
        line(matrix, 1, 1, RIGHT, matrix[0].length, matrix.length);
        return ans;
    }

    private static final String RIGHT = "right";
    private static final String DOWN = "down";
    private static final String LEFT = "left";
    private static final String UP = "up";

    private void line(int[][] matrix, int x, int y, String dir, int xn, int yn) {

        if (xn == 0 || yn == 0) {
            return;
        }
        switch (dir) {
            case RIGHT:
                for (int i = 0; i < xn; i++) {
                    ans.add(matrix[y - 1][i + x - 1]);
                }
                if (yn - 1 > 0) {
                    line(matrix, x + xn - 1, y + 1, DOWN, xn, yn - 1);
                } else return;
                break;
            case DOWN:
                for (int i = 0; i < yn; i++) {
                    ans.add(matrix[i + y - 1][y]);
                }
                if (x - 1 > 0) {
                    line(matrix, x - 1, y + yn - 1, LEFT, xn - 1, yn);
                } else return;
                break;
            case LEFT:
                for (int i = xn; i > 0; i--) {
                    ans.add(matrix[y - 1][i - 1]);
                }
                if (y - yn > 0) {
                    line(matrix, x - xn + 1, y - 1, UP, xn, yn - 1);
                } else return;


                break;
            case UP:
                for (int i = yn; i > 0; i--) {
                    ans.add(matrix[i - 1 + y - yn][x - 1]);
                }
                if (x + 1 <= xn) {
                    line(matrix, x + 1, y - 1, RIGHT, xn - 1, yn);
                } else return;
                break;
        }
    }

}
