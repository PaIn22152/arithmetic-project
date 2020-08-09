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
        int pos = 0;
        int i = 0;
        while (i <= n) {
            if(pos<nums1.length){
                if (nums1[pos] > nums2[i]) {
                    insert(nums1, pos, nums2[i]);
                    pos++;
                    i++;
                }
                pos++;
            }else {
                nums1[pos-1]=nums2[n-1];
                break;
            }

        }
        PrintHelper.println(nums1);

    }

    private void insert(int[] nums, int pos, int num) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i > pos) {
                nums[i] = nums[i - 1];
            }
        }
        nums[pos] = num;
    }

}
