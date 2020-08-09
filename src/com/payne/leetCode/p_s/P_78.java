package com.payne.leetCode.p_s;

import com.payne.utils.PrintHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.utils
 * Date       2019/02/19 - 12:06
 * Author     Payne.
 * About      类描述：
 */

public class P_78 {

    // and p_90  https://leetcode.com/problems/subsets-ii/

    /**
     * https://leetcode.com/problems/subsets/
     * {1,2,3}
     * [0,1,1]  0-没有 1-有   子集{2,3}
     * 总数  2^length
     * {1,1,2,3}
     */

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<List<Integer>, Integer> map = new HashMap<>();
        int num = (int) Math.pow(2, nums.length);

        for (int i = 0; i < num; i++) {
            String binary = Integer.toBinaryString(i);
            String zero = "";
            for (int j = 0; j < nums.length - binary.length(); j++) {
                zero += "0";
            }
            binary = zero + binary;

            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < binary.length(); j++) {
                String s = binary.substring(j, j + 1);
                if ("1".equals(s)) {
                    list.add(nums[j]);
                }
            }
            Collections.sort(list);
            map.put(list, i);
        }

        for (Map.Entry<List<Integer>, Integer> tem : map.entrySet()) {
            res.add(tem.getKey());
        }
        return res;
    }


}
