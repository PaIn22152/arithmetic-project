package com.payne.leetCode.p_old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2018/11/15 - 10:06
 * Author     Payne.
 * About      类描述：
 */

public class P_39_CombinationSum {

    /**
     * https://leetcode.com/problems/combination-sum/description/
     * <p_old>
     * Given a set of candidate numbers (candidates) (without duplicates) and
     * a target number (target), find all unique combinations in candidates
     * where the candidate numbers sums to target.
     * <p_old>
     * The same repeated number may be chosen from candidates unlimited number of times.
     * Note:
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * <p_old>
     * Example 1:
     * Input: candidates = [2,3,6,7], target = 7,
     * A solution set is:
     * [
     * [7],
     * [2,2,3]
     * ]
     */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return my(candidates, target);
    }

    public List<List<Integer>> my(int[] candidates, int target) {
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> result = new ArrayList<>();
            ff(candidates, target, result);
        }
        return null;
    }

    public void ff(int[] candidates, int target, List<Integer> result) {

    }


    public List<List<Integer>> f1(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);

        return result;
    }

    private void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start) {
        if (target > 0) {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                cur.add(candidates[i]);
                getResult(result, cur, candidates, target - candidates[i], i);
                cur.remove(cur.size() - 1);
            }//for
        }//if
        else if (target == 0) {
            result.add(new ArrayList<Integer>(cur));
        }//else if
    }
}
