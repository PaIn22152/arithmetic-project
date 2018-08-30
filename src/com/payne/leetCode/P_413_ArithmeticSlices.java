package com.payne.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2018/08/30 - 12:15
 * Author     Payne.
 * About      类描述：
 */

public class P_413_ArithmeticSlices {
    /**
     * https://leetcode.com/problems/arithmetic-slices/description/
     * <p>
     * A sequence of number is called arithmetic if it consists of at least three elements and
     * if the difference between any two consecutive elements is the same.
     * <p>
     * For example, these are arithmetic sequence:
     * <p>
     * 1, 3, 5, 7, 9
     * 7, 7, 7, 7
     * 3, -1, -5, -9
     * The following sequence is not arithmetic.
     * <p>
     * 1, 1, 2, 5, 7
     * <p>
     * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair
     * of integers (P, Q) such that 0 <= P < Q < N.
     * <p>
     * A slice (P, Q) of array A is called arithmetic if the sequence:
     * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
     * <p>
     * The function should return the number of arithmetic slices in the array A.
     * <p>
     * <p>
     * Example:
     * <p>
     * A = [1, 2, 3, 4]
     * <p>
     * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
     */

    //用时约1h
    public int numberOfArithmeticSlices(int[] A) {
        return my(A);
    }

    public int my(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        if (A.length == 3) {
            return isArithmetic(A) ? 1 : 0;
        }
        int result = 0;
        Map<Integer,Integer> noMap=new HashMap<>();
        for (int length = 3; length <= A.length; length++) {
            int[] a = new int[length];
            for (int num = 0; num <= A.length - length; num++) {
                if(noMap.containsKey(num+length)){
                   continue;
                }
                for (int i = 0; i < length; i++) {
                    a[i] = A[i + num];
                }
                if (isArithmetic(a)) {
                    result++;
                }else {
                    noMap.put(num+length,num+length);
                }
            }
        }
        return result;
    }

    private boolean isArithmetic(int[] is) {
        if (is.length < 3) {
            return false;
        }
        int subtract = is[1] - is[0];
        for (int i = 1; i < is.length - 1; i++) {
            if (is[i] + subtract != is[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
