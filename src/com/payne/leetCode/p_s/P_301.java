package com.payne.leetCode.p_s;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.p_s
 * Date       2019/12/23 - 11:58
 * Author     Payne.
 * About      类描述：
 */

public class P_301 {

    /**
     * 输入: "(a)())()"
     * 输出: ["(a)()()", "(a())()"]
     */
    private static final char LEFT = '(';
    private static final char RIGHT = ')';

    public List<String> removeInvalidParentheses(String s) {

        List<Integer> delRight = new ArrayList<>();
        int delLeftNum = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (LEFT == chars[i]) {
                delLeftNum++;
            } else if (RIGHT == chars[i]) {
                delLeftNum--;
            }
            if (delLeftNum < 0) {
                delRight.add(i);
                delLeftNum = 0;
            }
        }

        List<List<Integer>> del = new ArrayList<>();
        for (int i = 0; i < delRight.size(); i++) {
            List<Integer> tem = new ArrayList<>();
            for (int j = 0; j < delRight.get(i); j++) {
                tem.add(j);
            }
            del.add(tem);
        }


        return null;
    }


    private boolean isValid(String s) {
        int num = 0;
        for (char c : s.toCharArray()) {
            if (LEFT == c) {
                num++;
            } else if (RIGHT == c) {
                num--;
            }
            if (num < 0) {
                return false;
            }
        }
        return num == 0;
    }


    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = 1;
            if (hashMap.containsKey(nums[i])) {
                num = hashMap.get(nums[i]) + 1;
            }
            hashMap.put(nums[i], num);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (i < list.size()) {
                res.add(list.get(i).getKey());
            }
        }
        return res;
    }


}
