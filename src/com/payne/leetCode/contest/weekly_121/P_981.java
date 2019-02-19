package com.payne.leetCode.contest.weekly_121;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_121
 * Date       2019/01/31 - 17:08
 * Author     Payne.
 * About      类描述：
 */

public class P_981 {
    /**
     * https://leetcode.com/contest/weekly-contest-121/problems/time-based-key-value-store/
     */


    public static class Value {
        String value;
        int timestamp;

        public Value(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public static class TimeMap {
        /**
         * Initialize your data structure here.
         */
        HashMap<String, List<Value>> map;


        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {

            Value tem = new Value(value, timestamp);
            List<Value> values = new ArrayList<>();
            if (map.containsKey(key)) {
                values.addAll(map.get(key));
            }
            values.add(tem);
            map.put(key, values);

        }

        public String get(String key, int timestamp) {
            List<Value> values = map.get(key);
            values.sort((o1, o2) -> o2.timestamp - o1.timestamp);
            for (Value tem : values) {
                if (tem.timestamp <= timestamp) {
                    return tem.value;
                }
            }
            return "";
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */