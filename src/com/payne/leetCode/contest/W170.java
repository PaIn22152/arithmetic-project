package com.payne.leetCode.contest;

import java.util.*;

public class W170 {


    public String freqAlphabets(String s) {

        StringBuilder res = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {

            String sub = s.substring(i, i + 1);
            if ("#".equals(sub) && i >= 2) {
                sub = s.substring(i - 2, i);
                i -= 2;
            }
            int num = Integer.parseInt(sub);
            res.insert(0, getStr(num));
        }
        return res.toString();
    }

    private String getStr(int num) {
        char a = 'a';
        char res = (char) (a + num - 1);
        return res + "";
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = xorInt(arr, queries[i]);
        }
        return res;
    }

    private int xorInt(int[] arr, int[] q) {
        int n = 0;
        for (int i = q[0]; i <= q[1]; i++) {
            n = n ^ arr[i];
        }
        return n;
    }


    public int minInsertions(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        int num = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (hashSet.contains(chars[i])) {
                num += 2;
                hashSet.remove(chars[i]);
            } else {
                hashSet.add(chars[i]);
            }
        }
        return s.length() - num;

    }

    public boolean check(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length() / 2; i++) {
            if (chars[i] != chars[s.length() - 1 - i]) {
                return false;
            }
        }
        return true;
    }


    public List<String> watchedVideosByFriends(
            List<List<String>> watchedVideos,
            int[][] friends, int id, int level) {
        HashMap<Integer, HashSet<Integer>> hashMap = new HashMap<>();
        HashSet<Integer> hashSet = new HashSet<>();
        hashMap.put(0, new HashSet<>(id));
        for (int i = 0; i < level; i++) {
            HashSet<Integer> tem = new HashSet<>();
            HashSet<Integer> integers = hashMap.get(i);
            for (int j = 0; j < integers.size(); j++) {
                for (int k = 0; k < friends[j].length; k++) {
                    int n = friends[j][k];
                    if (!hashSet.contains(n)) {
                        tem.add(n);
                        hashSet.add(n);
                    }

                }
            }
            hashMap.put(i + 1, tem);
        }
        HashSet<Integer> f = hashMap.get(level);

        HashMap<String, Integer> h = new HashMap<>();
        for (Integer n : f) {
            List<String> strings = watchedVideos.get(n);
            for (String s : strings) {
                if (h.containsKey(s)) {
                    h.put(s, h.get(s) + 1);
                } else {
                    h.put(s, 1);
                }
            }
        }
        List<HashMap.Entry<String, Integer>> entries = new ArrayList<>(h.entrySet());
        Collections.sort(entries, new Comparator<HashMap.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().equals(o2.getValue())
                        ? o1.getKey().compareTo(o2.getKey()) : o1.getValue() - o2.getValue();
            }
        });
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> tem : entries) {
            res.add(tem.getKey());
        }
        return res;

    }


}
