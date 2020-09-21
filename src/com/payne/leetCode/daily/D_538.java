package com.payne.leetCode.daily;

import com.payne.leetCode.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/09/21 - 09:36
 * Author     Payne.
 * About      类描述：
 */

public class D_538 {

    /*
    * 538. 把二叉搜索树转换为累加树
给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
使得每个节点的值是原来的节点值加上所有大于它的节点值之和。

例如：
输入: 原始二叉搜索树:
              5
            /   \
           2     13
输出: 转换为累加树:
             18
            /   \
          20     13
    * */

    public TreeNode convertBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        toList(root, list);
        if (list.size() <= 1) {
            return root;
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int sum = list.get(0);
        int lasti = list.get(0);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < list.size(); i++) {
            if (lasti != list.get(i)) {
                sum += list.get(i);
                map.put(list.get(i), sum);
            }
        }
        changeTree(root, map);
        return root;
    }

    private void changeTree(TreeNode root, Map<Integer, Integer> map) {
        if (root != null) {
            if (map.containsKey(root.val)) {
                root.val = map.get(root.val);
            }
            changeTree(root.left, map);
            changeTree(root.right, map);
        }
    }

    private void toList(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            toList(root.left, list);
            toList(root.right, list);
        }
    }





    //官方代码
    int sum = 0;

    public TreeNode convertBST2(TreeNode root) {
        if (root != null) {
            convertBST2(root.right);
            sum += root.val;
            root.val = sum;
            convertBST2(root.left);
        }
        return root;
    }

}
