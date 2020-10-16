package com.payne.leetCode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/10/16 - 10:20
 * Author     Payne.
 * About      类描述：
 */

class D_977 {

    /*https://leetcode-cn.com/problems/squares-of-a-sorted-array/
    977. 有序数组的平方
给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。

示例 1：
输入：[-4,-1,0,3,10]
输出：[0,1,9,16,100]

示例 2：
输入：[-7,-3,2,3,11]
输出：[4,9,9,49,121]

提示：
1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A 已按非递减顺序排序。
    * */

    public int[] sortedSquares(int[] A) {
        int p = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                p = i;
                break;
            }
        }
        for (int i = 0; i < p; i++) {
            A[i] = -A[i];
        }
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        return A;
    }

    public int[] sortedSquares2(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    //理解官方提供的双指针思路后实现的代码
    public int[] sortedSquares3(int[] A) {
        int len = A.length;
        int left = 0;
        int right = len - 1;
        int pos = len - 1;
        int[] ans = new int[len];
        while (left <= right) {
            int vl = A[left] * A[left];
            int vr = A[right] * A[right];
            if (vr > vl) {
                ans[pos--] = vr;
                right--;
            } else {
                ans[pos--] = vl;
                left++;
            }
        }
        return ans;
    }
}
