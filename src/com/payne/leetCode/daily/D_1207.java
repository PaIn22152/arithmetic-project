package com.payne.leetCode.daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/10/28 - 09:47
 * Author     Payne.
 * About      类描述：
 */

class D_1207 {

    /*https://leetcode-cn.com/problems/unique-number-of-occurrences/
    * 1207. 独一无二的出现次数
给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。

示例 1：
输入：arr = [1,2,2,1,1,3]
输出：true
解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。

示例 2：
输入：arr = [1,2]
输出：false

示例 3：
输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
输出：true

提示：
1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000
    * */

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (set.contains(entry.getValue())) {
                return false;
            }
            set.add(entry.getValue());
        }
        return true;
    }
}
