package com.payne.leetCode.p_s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by payne on 2017-12-24.
 * About 类描述：
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * S = [-4,-1,-1, 0, 1, 2 ]
 */
public class P_15_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        //return my(nums);
        return f1(nums);
        //return f2(nums);
    }

    public List<List<Integer>> f1(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        int mySum = 0;
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || num[i] != num[i - 1]) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    mySum++;
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) {
                            lo++;
                        }
                        while (lo < hi && num[hi] == num[hi - 1]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        System.out.println("   mySum = " + mySum);
        return res;
    }

    public List<List<Integer>> f2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0) {
                break;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
                if (sum <= 0) {
                    while (nums[j] == nums[++j] && j < k) {
                        ;
                    }
                }
                if (sum >= 0) {
                    while (nums[k--] == nums[k] && j < k) {
                        ;
                    }
                }
            }
            while (nums[i] == nums[++i] && i < nums.length - 2) {
                ;
            }
        }
        return result;
    }

    private List<List<Integer>> my2(int[] nums) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int num1 = nums[i];
                int num2 = nums[j];

                if (num1 < num2) {
                    map.put(num1 + "," + num2, (num1 + num2)+","+i+","+j);
                }else {
                    map.put(num2 + "," + num1, (num1 + num2)+","+j+","+i);
                }

            }
        }

        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            int wantNum = 0 - nums[i];
            for(Map.Entry<String,String> tem:map.entrySet()){
                if(Integer.parseInt(tem.getValue().split(",")[0])==wantNum){
                    list.clear();
                    list.add(nums[i]);
                    list.add(nums[Integer.parseInt(tem.getValue().split(",")[1])]);
                    list.add(nums[Integer.parseInt(tem.getValue().split(",")[2])]);
                }
            }
            result.add(list);

        }
        return result;
    }


    public List<List<Integer>> my(int[] nums) {

        addSum = 0;
        subSum = 0;

        List<List<Integer>> result = new LinkedList<>();
        HashMap<Integer, Integer> map = getMap(nums);
        HashMap<List<Integer>, String> repeatingMap = new HashMap<>();

        long time1 = System.currentTimeMillis();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int num1 = nums[i];
                int num2 = nums[j];
                subMap(map, num1);
                subMap(map, num2);
                int wantNum = 0 - nums[i] - nums[j];
                if (map.containsKey(wantNum) && map.get(wantNum) > 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(num1);
                    list.add(num2);
                    list.add(wantNum);
                    Collections.sort(list);
                    if (!repeatingMap.containsKey(list)) {
                        result.add(list);
                        repeatingMap.put(list,
                                " i = " + i + "; j =" + j);
                    }
                }
                addMap(map, num1);
                addMap(map, num2);
            }
        }

//    long time2 = System.currentTimeMillis();
//    System.out.println(
//        "   time11111 = " + (time2 - time1) + "  addSum = " + addSum + "  subSum = " + subSum);

        return result;
    }

    int addSum = 0;

    public void addMap(HashMap<Integer, Integer> map, int num) {
        addSum++;
        map.put(num, map.get(num) + 1);
        // map.put(num,  1);
        //map.get(num);
    }

    int subSum = 0;

    public void subMap(HashMap<Integer, Integer> map, int num) {
        subSum++;
        map.put(num, map.get(num) - 1);
        //map.put(num,  1);
        //map.get(num);
    }

    public HashMap<Integer, Integer> getMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                Integer num = map.get(i);
                map.put(i, num + 1);
            } else {
                map.put(i, 1);
            }
        }
        return map;
    }


}
