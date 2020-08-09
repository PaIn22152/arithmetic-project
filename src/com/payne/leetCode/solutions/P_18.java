package com.payne.leetCode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_18 {


    //解法1
    //算法原理，排序，双重遍历，双指针

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 4) {
            return res;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {//最小数大于0，则和一定大于0，退出循环
                break;
            }
            while (i > 0 && nums[i] == nums[i - 1]) {
                i++;
            }
            if (i > len) {
                break;
            }
            for (int j = i + 1; j < len; j++) {
                while (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                }
                if (j > len) {
                    break;
                }
                int leftP = j + 1;
                int rightP = len - 1;
                while (leftP < rightP) {
                    int sum = nums[i] + nums[j] + nums[leftP] + nums[rightP];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[leftP], nums[rightP]));
                        while (leftP < rightP && nums[leftP + 1] == nums[leftP]) {
                            leftP++;
                        }
                        while (leftP < rightP && nums[rightP] == nums[rightP - 1]) {
                            rightP--;
                        }
                        leftP++;
                        rightP--;
                    } else if (sum > target) {
                        rightP--;
                    } else if (sum < target) {
                        leftP++;
                    }
                }
            }
        }
        return res;
    }
}
