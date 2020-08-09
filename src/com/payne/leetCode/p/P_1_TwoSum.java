package com.payne.leetCode.p;

/**
 * Created by payne on 2017-12-19. About 类描述：
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific
 * target. You may assume that each input would have exactly one solution, and you may not use the
 * same element twice. Example: Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] =
 * 2 + 7 = 9, return [0, 1].
 *
 */
public class P_1_TwoSum {

  public int[] twoSum(int[] nums, int target) {


    int[] result = new int[2];
    if (nums.length < 2) {
      return result;
    }
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          if (i < j) {
            result[0] = i;
            result[1] = j;
          } else {
            result[0] = j;
            result[1] = i;
          }
          return result;
        }
      }
    }
    return result;


  }
}
