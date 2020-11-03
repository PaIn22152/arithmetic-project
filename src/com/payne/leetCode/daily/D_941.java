package com.payne.leetCode.daily;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/11/03 - 18:49
 * Author     Payne.
 * About      类描述：
 */

class D_941 {

    /*https://leetcode-cn.com/problems/valid-mountain-array/
    * 941. 有效的山脉数组
给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：

A.length >= 3
在 0 < i < A.length - 1 条件下，存在 i 使得：
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]

示例 1：
输入：[2,1]
输出：false

示例 2：
输入：[3,5,5]
输出：false

示例 3：
输入：[0,3,2,1]
输出：true

提示：
0 <= A.length <= 10000
0 <= A[i] <= 10000
    * */

    public boolean validMountainArray(int[] A) {
        int last = -1;
        int upNum = 0;
        boolean up = true;
        for (int i : A) {
            if (up) {
                if (i < last) {
                    up = false;
                } else if (i == last) {
                    return false;
                } else {
                    upNum++;
                }
                last = i;
            } else {
                if (upNum <= 1) {
                    return false;
                }
                if (i >= last) {
                    return false;
                }
                last = i;
            }
        }
        if (upNum <= 1) {
            return false;
        }
        if (up) {
            return false;
        }
        return true;
    }


    //官方代码
    public boolean validMountainArray2(int[] A) {
        int N = A.length;
        int i = 0;

        // 递增扫描
        while (i + 1 < N && A[i] < A[i + 1]) {
            i++;
        }

        // 最高点不能是数组的第一个位置或最后一个位置
        if (i == 0 || i == N - 1) {
            return false;
        }

        // 递减扫描
        while (i + 1 < N && A[i] > A[i + 1]) {
            i++;
        }

        return i == N - 1;
    }

}
