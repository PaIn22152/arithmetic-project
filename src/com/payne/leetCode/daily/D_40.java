package com.payne.leetCode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/09/10 - 18:22
 * Author     Payne.
 * About      类描述：
 */

public class D_40 {
    /*
    40. 组合总和 II
给定一个数组 candidates 和一个目标数 target ，
找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。

说明：
所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。

示例 1:
输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

示例 2:
输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
    * */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (target <= 0) {
            return ans;
        }
        Set<Integer> set = new HashSet<>();
        boolean add;
        int index;
        for (int i = 0; i < candidates.length; i++) {
            if (target == candidates[i]) {
                List<Integer> list = new ArrayList<>();
                list.add(target);
                if (!set.contains(list.hashCode())) {
                    ans.add(list);
                    set.add(list.hashCode());
                }
            } else {
                int[] can = new int[candidates.length - 1];
                index = 0;
                for (int j = 0; j < candidates.length; j++) {
                    if (j != i) {
                        can[index++] = candidates[j];
                    }
                }
                int tar = target - candidates[i];
                List<List<Integer>> lists = combinationSum2(can, tar);
                for (List<Integer> tem : lists) {
                    add = false;
                    for (int j = 0; j < tem.size(); j++) {
                        if (candidates[i] <= tem.get(j)) {
                            tem.add(j, candidates[i]);
                            add = true;
                            break;
                        }
                    }
                    if (!add) {
                        tem.add(candidates[i]);
                    }
                    if (!set.contains(tem.hashCode())) {
                        ans.add(tem);
                        set.add(tem.hashCode());
                    }

                }
            }
        }
        return ans;
    }


    //动态规划
    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i:candidates){
            if(target==i){
                List<Integer> list = new ArrayList<>();
                list.add(target);
                ans.add(list);
            }
        }
    }


}
