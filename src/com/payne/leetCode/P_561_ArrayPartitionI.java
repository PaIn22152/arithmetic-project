package com.payne.leetCode;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by payne on 2018-01-07.
 * About 类描述：
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 * say (a1, b1), (a2, b2), ..., (an, bn)
 * which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * Note:
 n is a positive integer, which is in the range of [1, 10000].
 All the integers in the array will be in the range of [-10000, 10000].
 */
public class P_561_ArrayPartitionI {


	public int arrayPairSum(int[] nums) {
		return my(nums);
	}

	/**
	 * 完成时间，5min6sec
	 * */
	public int my(int[] nums) {
		Arrays.sort(nums);
		int result = 0;
		for (int i = 0; i < nums.length; i += 2) {
			result += nums[i - 1];
		}
		return result;
	}

}
