package com.payne.leetCode.p_s;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2018/11/13 - 11:51
 * Author     Payne.
 * About      类描述：
 */

public class P_48_RotateImage {
    /**
     * https://leetcode.com/problems/rotate-image/description/
     * <p_old>
     * You are given an n x n 2D matrix representing an image.
     * Rotate the image by 90 degrees (clockwise).
     * <p_old>
     * Given input matrix =
     * [
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * ],
     * <p_old>
     * rotate the input matrix in-place such that it becomes:
     * [
     * [7,4,1],
     * [8,5,2],
     * [9,6,3]
     * ]
     */

    public void rotate(int[][] matrix) {
        my(matrix);
    }

    public void my(int[][] matrix) {
        int len = matrix.length;
        int[][] ref = new int[len][len];
        System.arraycopy(matrix, 0, ref, 0, len);

        for (int i = 0; i < len; i++) {
            int[] tem = new int[len];
            for (int j = 0; j < len; j++) {
                tem[j] = ref[len - 1 - j][i];
            }
            matrix[i] = tem;
        }
    }
}
