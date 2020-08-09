package com.payne.leetCode.p_s;

/**
 * Created by payne on 2017-12-20.
 * About 类描述：
 */
public class P_4_MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ints = combineArrays(nums1, nums2);
        if (ints.length % 2 == 1) {
            return ints[(ints.length - 1) / 2];
        } else {
            return ((double) (ints[ints.length / 2] + ints[ints.length / 2 - 1])) / 2;
        }
    }

    private int[] combineArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (i1 >= nums1.length) {
                result[i] = nums2[i2];
                i2 += 1;
            } else if (i2 >= nums2.length) {
                result[i] = nums1[i1];
                i1 += 1;
            } else {
                if (nums1[i1] < nums2[i2]) {
                    result[i] = nums1[i1];
                    i1 += 1;
                } else {
                    result[i] = nums2[i2];
                    i2 += 1;
                }
            }
        }
        return result;
    }

}
