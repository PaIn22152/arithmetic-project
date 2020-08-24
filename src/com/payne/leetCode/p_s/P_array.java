package com.payne.leetCode.p_s;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.p_s
 * Date       2020/08/24 - 10:43
 * Author     Payne.
 * About      类描述：
 */

public class P_array {

    // [-1,-1,0,-1,-1,-1]
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int vl = nums[left];
        int vr = nums[right];
        int d1, d2;
        while (left != right) {
            if (vl == vr) {
                vr += nums[--right];
            } else if (vl < vr) {
                d1 = vr - (vl + nums[left + 1]);
                d2 = vr + nums[right - 1] - vl;
                if (d1 < d2) {
                    vl += nums[++left];
                } else {
                    vr += nums[--right];
                }
            } else if (vl > vr) {
                d1 = vl + nums[left] - vr;
                d2 = vl - (vr + nums[right - 1]);
                if (d1 < d2) {
                    vl += nums[++left];
                } else {
                    vr += nums[--right];
                }
            }
        }
        if (vl == vr) {
            return left;
        }
        return -1;
    }


    public int pivotIndex2(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        int left, right;
        for (int i = 0; i < nums.length; i++) {
            left = 0;
            for (int l = 0; l < i; l++) {
                left += nums[l];
            }
            right = 0;
            for (int r = i + 1; r < nums.length; r++) {
                right += nums[r];
            }
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}
