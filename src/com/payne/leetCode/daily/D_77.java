package com.payne.leetCode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/09/08 - 10:26
 * Author     Payne.
 * About      类描述：
 */

public class D_77 {

    /*
    77. 组合
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
    * */

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k <= n) {
            if (k == 1) {
                for (int i = 1; i <= n; i++) {
                    List<Integer> tem = new ArrayList<>();
                    tem.add(i);
                    ans.add(tem);
                }
            } else {
                for (int i = 1; i <= n; i++) {
                    List<List<Integer>> res = combine(i - 1, k - 1);
                    for (List<Integer> tem : res) {
                        tem.add(i);
                        ans.add(tem);
                    }
                }
            }
        }
        return ans;
    }

    /*
     * 思考过程
     * 因为[1,2] 和 [2,1] 表示的是同一种组合方式，
     * 假设第一轮先取包含n的数组，
     * */


}
