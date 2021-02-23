package com.payne.leetCode.p_s;

import com.payne.leetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.p_s
 * Date       2020/09/17 - 17:08
 * Author     Payne.
 * About      类描述：
 */

public class P_129 {

    /*
    * 129. 求根到叶子节点数字之和
给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

例如，从根到叶子节点路径 1->2->3 代表数字 123。

计算从根到叶子节点生成的所有数字之和。

说明: 叶子节点是指没有子节点的节点。

示例 1:

输入: [1,2,3]
    1
   / \
  2   3
输出: 25
解释:
从根到叶子节点路径 1->2 代表数字 12.
从根到叶子节点路径 1->3 代表数字 13.
因此，数字总和 = 12 + 13 = 25.
示例 2:

输入: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
输出: 1026
解释:
从根到叶子节点路径 4->9->5 代表数字 495.
从根到叶子节点路径 4->9->1 代表数字 491.
从根到叶子节点路径 4->0 代表数字 40.
因此，数字总和 = 495 + 491 + 40 = 1026.
    * */


    /**
     * 队列
     * 执行用时：2 ms, 在所有 Java 提交中击败了16.87%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了5.03%的用户
     */
    public int sumNumbers3(TreeNode root) {
        int sum = 0;
        List<Queue<Integer>> bfs = bfs3(root);
        for (Queue<Integer> queue : bfs) {
            int m = 1;
            while (!queue.isEmpty()) {
                sum += queue.poll() * m;
                m *= 10;
            }
        }
        return sum;
    }

    private List<Queue<Integer>> bfs3(TreeNode root) {
        List<Queue<Integer>> ans = new ArrayList<>();
        if (root != null) {
            if (root.left == null && root.right == null) {
                Queue<Integer> t = new LinkedList<>();
                t.add(root.val);
                ans.add(t);
                return ans;
            } else {
                List<Queue<Integer>> left = bfs3(root.left);
                for (Queue<Integer> queue : left) {
                    queue.add(root.val);
                    ans.add(queue);
                }

                List<Queue<Integer>> right = bfs3(root.right);
                for (Queue<Integer> queue : right) {
                    queue.add(root.val);
                    ans.add(queue);
                }
            }
        }
        return ans;
    }

    /**
     * list
     * 执行用时：1 ms, 在所有 Java 提交中击败了29.37%的用户
     * 内存消耗：37.1 MB, 在所有 Java 提交中击败了8.04%的用户
     */
    public int sumNumbers2(TreeNode root) {
        int sum = 0;
        List<List<Integer>> bfs = bfs2(root);
        for (List<Integer> list : bfs) {
            int m = 1;
            for (int i : list) {
                sum += i * m;
                m *= 10;
            }
        }
        return sum;

    }


    private List<List<Integer>> bfs2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            if (root.left == null && root.right == null) {
                List<Integer> t = new ArrayList<>();
                t.add(root.val);
                ans.add(t);
                return ans;
            } else {
                List<List<Integer>> left = bfs2(root.left);
                for (List<Integer> list : left) {
                    list.add(root.val);
                    ans.add(list);
                }

                List<List<Integer>> right = bfs2(root.right);
                for (List<Integer> list : right) {
                    list.add(root.val);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


    /**
     * StringBuilder
     * 执行用时：4 ms, 在所有 Java 提交中击败了9.24%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了5.03%的用户
     */
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        List<StringBuilder> bfs = bfs(root);
        for (StringBuilder sb : bfs) {
            sum += (Integer.parseInt(sb.toString()));
        }
        return sum;

    }

    private List<StringBuilder> bfs(TreeNode root) {
        List<StringBuilder> ans = new ArrayList<>();
        if (root != null) {
            if (root.left == null && root.right == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(root.val);
                ans.add(sb);
                return ans;
            } else {
                List<StringBuilder> left = bfs(root.left);
                for (StringBuilder sb : left) {
                    sb.insert(0, root.val);
                    ans.add(sb);
                }

                List<StringBuilder> right = bfs(root.right);
                for (StringBuilder sb : right) {
                    sb.insert(0, root.val);
                    ans.add(sb);
                }
            }
        }

        return ans;
    }
}
