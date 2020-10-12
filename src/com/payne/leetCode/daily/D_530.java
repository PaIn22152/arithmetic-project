package com.payne.leetCode.daily;

import com.payne.leetCode.TreeNode;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/10/12 - 11:34
 * Author     Payne.
 * About      类描述：
 */

class D_530 {

    /*https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
    * 530. 二叉搜索树的最小绝对差
给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。

示例：
输入：
   1
    \
     3
    /
   2
输出：
1
解释：
最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。

提示：
树中至少有 2 个节点。
本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
    * */

    /*
    执行用时：1 ms, 在所有 Java 提交中击败了82.39%的用户
    内存消耗：37.9 MB, 在所有 Java 提交中击败了99.81%的用户
    * */
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int i1 = Math.min(left(root), right(root));
        int i2 = Math.min(getMinimumDifference(root.left), getMinimumDifference(root.right));
        return Math.min(i1, i2);
    }

    private int left(TreeNode root) {
        if (root.left == null) {
            return Integer.MAX_VALUE;
        }
        TreeNode tem = root.left;
        int right = tem.val;
        while (tem != null) {
            right = tem.val;
            tem = tem.right;
        }
        return root.val - right;
    }

    private int right(TreeNode root) {
        if (root.right == null) {
            return Integer.MAX_VALUE;
        }
        TreeNode tem = root.right;
        int left = tem.val;
        while (tem != null) {
            left = tem.val;
            tem = tem.left;
        }
        return left - root.val;
    }



    //官方解法
    /*
    执行用时：1 ms, 在所有 Java 提交中击败了82.39%的用户
    内存消耗：38.6 MB, 在所有 Java 提交中击败了52.19%的用户
    * */
    int pre;
    int ans;

    public int getMinimumDifference2(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

}
