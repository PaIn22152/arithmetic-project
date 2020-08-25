package com.payne.leetCode.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/08/25 - 09:22
 * Author     Payne.
 * About      类描述：
 */

public class D_491 {

    /**
     * 491. 递增子序列
     * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
     * 示例:
     * 输入: [4, 6, 7, 7]
     * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
     * <p>
     * 说明:
     * 给定数组的长度不会超过15。
     * 数组中的整数范围是 [-100,100]。
     * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
     * <p>
     * https://leetcode-cn.com/problems/increasing-subsequences/
     */

    public List<List<Integer>> findSubsequences2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        //找到所有长度为2的子序列
        Set<String> set = new HashSet<>();
        List<String> leftRight = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= nums[i] && !set.contains(nums[i] + "-" + nums[j])) {
                    List<Integer> tem = new ArrayList<>();
                    tem.add(nums[i]);
                    tem.add(nums[j]);
                    ans.add(new ArrayList<>(tem));
                    map.put(i + "-" + j, new ArrayList<>(tem));
                    set.add(nums[i] + "-" + nums[j]);
                    leftRight.add(i + "-" + j);
                }
            }
        }


        Map<String, List<Integer>> temMap = new HashMap<>();
        List<String> temLeftRight = new ArrayList<>();
        //在长度为2的子序列的基础上，找到长度3-n的子序列
        for (int len = 3; len <= nums.length; len++) {
            temMap.clear();
            temLeftRight.clear();
            for (String s : leftRight) {
                String[] ss = s.split("-");
                int right = Integer.parseInt(ss[ss.length - 1]);
                List<Integer> lastJ = new ArrayList<>();
                for (int j = right + 1; j < nums.length; j++) {
                    if (nums[j] >= nums[right]) {
                        boolean add = true;
                        for (int lj : lastJ) {
                            if (nums[j] == nums[lj]) {
                                add = false;
                            }
                        }
                        if (add) {
                            lastJ.add(j);
                            List<Integer> tem = new ArrayList<>(map.get(s));
                            tem.add(nums[j]);
                            ans.add(tem);
                            temMap.put(s + "-" + j, tem);
                            temLeftRight.add(s + "-" + j);
                        }
                    }
                }
            }
            map.clear();
            map.putAll(temMap);

            leftRight.clear();
            leftRight.addAll(temLeftRight);
        }

        return ans;
    }

    /**
     思考过程
     输入的数组长度为n，那么子序列的长度范围是[2,n]
     而且长度为3的子序列，一定是在长度2的基础上，再往右找，依次
     所以应该先找所有长度2的子序列，在此基础上找到3，一直到n
     * */


    //官方代码
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Set<Integer> set = new HashSet<Integer>();
    int n;

    public List<List<Integer>> findSubsequences(int[] nums) {
        n = nums.length;
        for (int i = 0; i < (1 << n); ++i) {
            findSubsequences(i, nums);
            int hashValue = getHash(263, (int) 1E9 + 7);
            if (check() && !set.contains(hashValue)) {
                ans.add(new ArrayList<Integer>(temp));
                set.add(hashValue);
            }
        }
        return ans;
    }

    public void findSubsequences(int mask, int[] nums) {
        temp.clear();
        for (int i = 0; i < n; ++i) {
            if ((mask & 1) != 0) {
                temp.add(nums[i]);
            }
            mask >>= 1;
        }
    }

    public int getHash(int base, int mod) {
        int hashValue = 0;
        for (int x : temp) {
            hashValue = hashValue * base % mod + (x + 101);
            hashValue %= mod;
        }
        return hashValue;
    }

    public boolean check() {
        for (int i = 1; i < temp.size(); ++i) {
            if (temp.get(i) < temp.get(i - 1)) {
                return false;
            }
        }
        return temp.size() >= 2;
    }

}
