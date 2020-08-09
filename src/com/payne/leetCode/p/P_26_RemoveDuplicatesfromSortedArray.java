package com.payne.leetCode.p;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.utils
 * Date       2018/11/28 - 10:12
 * Author     Payne.
 * About      类描述：
 */

public class P_26_RemoveDuplicatesfromSortedArray {
    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
     * <p>
     * Given a sorted array nums, remove the duplicates in-place such that each element
     * appear only once and return the new length.
     * <p>
     * Do not allocate extra space for another array, you must do this by modifying
     * the input array in-place with O(1) extra memory.
     * <p>
     * Example 1:
     * Given nums = [1,1,2],
     * Your function should return length = 2, with the first two elements of
     * nums being 1 and 2 respectively.
     * It doesn't matter what you leave beyond the returned length.
     * [0,0,1,1,1,2,2,3,3,4]
     */


    public int removeDuplicates(int[] nums) {
        return my(nums);
    }

    public int my(int[] nums) {
        int len = nums.length;
        int rep = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                if (i != len - 1) {
                    nums[i] = nums[i + 1];
                    nums[i+1]=Integer.MAX_VALUE;
                }
                rep++;
            }
        }
        return len - rep;
    }


}
