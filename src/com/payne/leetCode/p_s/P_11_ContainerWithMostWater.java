package com.payne.leetCode.p_s;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2018/08/10 - 12:06
 * Author     Payne.
 * About      类描述：
 */

public class P_11_ContainerWithMostWater {
    /**
     * https://leetcode.com/problems/container-with-most-water/description/
     */

    //用时2min58s
    public int maxArea(int[] height) {
        return my(height);
    }

    //暴力解法，遍历所有可能
    public int my(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                result = Math.max(area, result);
            }
        }
        return result;
    }


    //双指针
    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;

    }
}
