package com.payne.leetCode.daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/09/11 - 09:42
 * Author     Payne.
 * About      类描述：
 */

public class D_216 {

    /*
    216. 组合总和 III
找出所有相加之和为 n 的 k 个数的组合。
组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：
所有数字都是正整数。
解集不能包含重复的组合。

示例 1:
输入: k = 3, n = 7
输出: [[1,2,4]]

示例 2:
输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]
    * */

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        boolean add;
        boolean have;
        if (k == 1 && n >= 1 && n <= 9) {
            List<Integer> tem = new ArrayList<>();
            tem.add(n);
            ans.add(tem);
        } else if (k > 1 && n > 0) {
            for (int i = 1; i <= 9; i++) {
                List<List<Integer>> lists = combinationSum3(k - 1, n - i);
                have = false;
                add = false;
                for (List<Integer> list : lists) {
                    for (int j = 0; j < list.size(); j++) {
                        if (i < list.get(j)) {
                            list.add(j, i);
                            add = true;
                            break;
                        } else if (i == list.get(j)) {
                            have = true;
                            break;
                        }
                    }
                    if (!add) {
                        list.add(i);
                    }
                    if (!have && !set.contains(list.hashCode())) {
                        ans.add(list);
                        set.add(list.hashCode());
                    }
                }
            }
        }
        return ans;
    }
}
