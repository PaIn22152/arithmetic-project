package com.payne.leetCode.p_s;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by payne on 2017-12-20.
 * About 类描述：
 *
 * Given an array nums, there is a sliding window of size k which is moving from the
 * very left of the array to the very right. You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 * Your job is to output the median array for each window in the original array.
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * Window position                Median
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * 1 [3  -1  -3] 5  3  6  7       -1
 * 1  3 [-1  -3  5] 3  6  7       -1
 * 1  3  -1 [-3  5  3] 6  7       3
 * 1  3  -1  -3 [5  3  6] 7       5
 * 1  3  -1  -3  5 [3  6  7]      6
 * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 */
public class P_480_SlidingWindowMedian {

  public double[] medianSlidingWindow(int[] nums, int k) {
    int length = nums.length - k + 1;
    double[] result = new double[length];
    List<int[]> list = getNumsList(nums, k);
    for (int i = 0; i < list.size(); i++) {
      double median = getMedian(list.get(i));
      result[i] = median;
    }
    return result;
  }

  public List<int[]> getNumsList(int[] nums, int k) {
    int length = nums.length - k + 1;
    List<int[]> result = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      int[] newNums = new int[k];
      for (int j = 0; j < k; j++) {
        newNums[j] = nums[i + j];
      }
      result.add(newNums);
    }
    return result;
  }

  public int[] sort(int[] nums) {
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      result[i] = nums[i];
    }
    /*for (int i = 0; i < result.length - 1; i++) {
      int left = result[i];
      int right = result[i + 1];
      if (left > right) {
        result[i] = right;
        result[i + 1] = left;
      }
    }*/

    int temp = 0;
    int size = result.length;
    for(int i = 0 ; i < size-1; i ++)
    {
      for(int j = 0 ;j < size-1-i ; j++)
      {
        if(result[j] > result[j+1])  //交换两数位置
        {
          temp = result[j];
          result[j] = result[j+1];
          result[j+1] = temp;
        }
      }
    }



    return result;
  }

  public double getMedian(int[] nums) {
    int[] newNums = sort(nums);
    if (newNums.length % 2 == 1) {
      return newNums[(newNums.length - 1) / 2];
    } else {
      return ( ((double)newNums[newNums.length / 2] + (double) newNums[newNums.length / 2 - 1])) / 2;
    }
  }



  public int magicalString(int n) {
    if (n == 0) return 0;
    else if (n <= 3) return 1;

    int[] num = new int[n];
    int result = 1;
    num[0] = 1;
    num[1] = 2;
    boolean one = false;
    int index = 1;
    for (int i = 1; i < n; i++) {
      for (int j = num[index]; j > 0; j--) {
        if (i >= n) break;
        num[i] = one ? 1 : 2;
        if (one) result ++;
        i++;
      }
      i--;

      one = !one;
      index ++;
    }

    return result;
  }

}
