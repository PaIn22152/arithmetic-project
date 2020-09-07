package com.payne.leetCode.daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/09/07 - 10:07
 * Author     Payne.
 * About      类描述：
 */

public class D_347 {
    /*347. 前 K 个高频元素
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]

示例 2:
输入: nums = [1], k = 1
输出: [1]


提示：
你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
你可以按任意顺序返回答案。

https://leetcode-cn.com/problems/top-k-frequent-elements/
     * */

    //
    static class Compettt {
        public int i;
        public int num;

        public Compettt(int ii, int numm) {
            i = ii;
            num = numm;
        }
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Compettt> map = new HashMap<>();
        for (int n = 0; n < nums.length; n++) {
            int i = nums[n];
            if (!map.containsKey(i)) {
                map.put(i, new Compettt(i, 1));
            } else {
                map.put(i, new Compettt(i, 1 + map.get(i).num));
            }
        }
        int[] ans = new int[k];
        List<Compettt> list = new ArrayList<>();
        for (Map.Entry<Integer, Compettt> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list, new Comparator<Compettt>() {
            @Override
            public int compare(Compettt o1, Compettt o2) {
                return o2.num - o1.num;
            }
        });
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i).i;
        }
        return ans;
    }


    public int[] topKFrequent3(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                int v = map.get(i);
                map.put(i, v + 1);

            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i).getKey();
        }
        return ans;
    }

    // []
    //10
    public int[] topKFrequent4(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
                list.add(1);
            } else {
                int v = map.get(i);
                map.put(i, v + 1);
                for (int in = 0; in < list.size(); in++) {
                    if (list.get(in) == v) {
                        list.remove(in);
                        break;
                    }
                }
                list.add(v + 1);
            }
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : list) {
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (e.getValue() == i) {
                    ans[--k] = e.getKey();
                    if (k <= 0) {
                        return ans;
                    }
                    map.remove(e.getKey());
                    break;
                }
            }
        }
        return ans;
    }


    //官方代码
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

}
