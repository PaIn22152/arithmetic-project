package com.payne.leetCode;

/**
 * Created by payne on 2017-12-28.
 * About 类描述：
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 Do not allocate extra space for another array,
 you must do this by modifying the input array in-place with O(1) extra memory.
 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 Example:
 Given nums = [3,2,2,3], val = 3,
 Your function should return length = 2, with the first two elements of nums being 2.
 */
public class P_27_RemoveElement {
	public int removeElement(int[] nums, int val) {
		return my(nums, val);
	}

	public int my(int[] nums, int val) {
		int cache = 0;
		if (val == 0) {
			cache = 1;
		}
		int num = 0;
		for (int i = 0; i < nums.length; ) {
			if (val == nums[i]) {
				num++;
				for (int j = i; j < nums.length - 1; j++) {
					nums[j] = nums[j + 1];
				}
				nums[nums.length - num] = cache;
			}
			else {
				i++;
			}

		}
		return nums.length - num;
	}

	public int f1(int[] A, int elem) {
		int len = A.length;
		for (int i = 0 ; i< len; ++i){
			while (A[i]==elem && i< len) {
				A[i]=A[--len];
			}
		}
		return len;
	}
}
