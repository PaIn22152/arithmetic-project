package com.payne.leetCode.contest.weekly_169;

import java.util.*;

public class W169 {


    public int[] sumZero(int n) {
        int[] res = new int[n];
        int p = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                res[i] = p;
            } else {
                res[i] = -p;
                p++;
            }
        }
        if (n % 2 == 0) {
            res[n - 1] = 0;
        }
        return res;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        add(res, root1, root2);

        Collections.sort(res);
        return res;
    }


    private void add(List<Integer> list, TreeNode l, TreeNode r) {
        if (l != null) {
            list.add(l.val);
            add(list, l.left, l.right);
        }
        if (r != null) {
            list.add(r.val);
            add(list, r.left, r.right);
        }
    }


    public boolean canReach(int[] arr, int start) {
        HashSet<Integer> hashSet = new HashSet<>();
        return jump(hashSet, arr, start);
    }

    private boolean jump(HashSet<Integer> hashSet, int[] arr, int p) {
        if (p < 0 || p >= arr.length) {
            return false;
        }
        if (arr[p] == 0) {
            return true;
        }
        if (hashSet.contains(p)) {
            return false;
        }
        hashSet.add(p);
        return jump(hashSet, arr, p + arr[p])
                || jump(hashSet, arr, p - arr[p]);
    }


//    public boolean isSolvable(String[] words, String result) {
//        HashMap<String, Integer> hashMap = new HashMap<>();
//
//
//    }


}


