package com.payne.leetCode.p_s;

import com.payne.utils.PrintHelper;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2019/02/20 - 15:19
 * Author     Payne.
 * About      类描述：
 */

public class P_88 {

    /**
     * https://leetcode.com/problems/merge-sorted-array/
     */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            boolean move = false;
            int last = 0;
            for (int j = 0; j < m + i + 1; j++) {
                if (move) {
                    int tem = nums1[j];
                    nums1[j] = last;
                    last = tem;
                } else if (nums1[j] > nums2[i]) {
                    last = nums1[j];
                    nums1[j] = nums2[i];
                    move = true;
                }
            }
            if (!move) {
                nums1[m + i] = nums2[i];
            }
        }

    }


}
