package com.payne.leetCode.p_s;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.p_s
 * Date       2020/08/13 - 14:15
 * Author     Payne.
 * About      类描述：
 */

public class P_805 {

    /**
     给定的整数数组 A ，我们要将 A数组 中的每个元素移动到 B数组 或者 C数组中。（B数组和C数组在开始的时候都为空）
     返回true ，当且仅当在我们的完成这样的移动后，可使得B数组的平均值和C数组的平均值相等，并且B数组和C数组都不为空。

     示例:
     输入:
     [1,2,3,4,5,6,7,8]
     输出: true

     解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
     注意:
     A 数组的长度范围为 [1, 30].
     A[i] 的数据范围为 [0, 10000].

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/split-array-with-same-average
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */


    /**
     * 解题思路
     * 当有解时，需满足b数组平均值=c数组平均值=a数组平均值
     * 找到n个数放入b，且n<a.length，使得b平均值=a平均值
     * 如果存在，返回true，不存在，返回false
     */
    public boolean splitArraySameAverage(int[] A) {
        float sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        float mean = sum / A.length;
        for (int i = 1; i <= A.length / 2; i++) {
            float all = mean * i;
            if (isInt(all)) {
                //在A中找i个数，和为all
                if (haveI(A, i, (int) all, new HashSet<>())) {
                    return true;
                }
            }
        }
        return false;

    }


    private boolean haveI(int[] ints, int num, int sum, Set<Integer> usedPos) {
        if (num == 1) {
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] == sum) {
                    return true;
                }
            }
            return false;
        }
        for (int i = 0; i < ints.length; i++) {
            if (!usedPos.contains(i)) {
                usedPos.add(i);
                if (haveI(ints, num - 1, sum - ints[i], usedPos)) {
                    return true;
                }else {
                    System.out.println();
                }

            }

        }
        return false;
    }

    private boolean isInt(float f) {
        return f - (int) f == 0;
    }

}
