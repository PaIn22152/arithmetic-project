package com.payne.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2018/11/13 - 12:29
 * Author     Payne.
 * About      类描述：
 */

public class P_47_PermutationsII {
    /**
     * https://leetcode.com/problems/permutations-ii/description/
     * <p>
     * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
     * Example:
     * Input: [1,1,2]
     * Output:
     * [
     * [1,1,2],
     * [1,2,1],
     * [2,1,1]
     * ]
     * <p>
     * O(n!)
     * 分治法
     */

    public List<List<Integer>> permuteUnique(int[] nums) {
        return my(nums);
    }

    Map<List<Integer>,Integer[]> map=new HashMap<>();
    public void test(int[] nums){
        for(Map.Entry<List<Integer>,Integer[]> entry:map.entrySet()){

        }
    }


//    Map<Integer,Integer[]> mapp=new HashMap<>();
//    public Map<Integer,Integer[]> testt(int[] nums){
//
//    }



    List<List<Integer>> lists;

    public int[] pop(int[] nums) {
        if (nums == null) {
            return new int[0];
        }
        int len = nums.length;
        int[] result = new int[len - 1];
        if (lists == null || lists.size() == 0) {
            lists = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                lists.add(list);

                for (int j = 0; j < len - 1; j++) {
                    if (j < i) {
                        result[j] = nums[i];
                    } else {
                        result[j] = nums[i + 1];
                    }
                }
                return result;

            }

        }
        return null;

    }

    public List<List<Integer>> my(int[] nums) {

        int len = nums.length;
        Map<List<Integer>, String> map = new HashMap<>();
        for (int i = len; i > 0; i--) {
            for (int j = 0; j < i; j++) {

            }
        }


        return null;
    }
}
