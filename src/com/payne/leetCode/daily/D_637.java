package com.payne.leetCode.daily;

import com.payne.leetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class D_637 {

    /*
    637. 二叉树的层平均值
给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
示例 1：
输入：
    3
   / \
  9  20
    /  \
   15   7
输出：[3, 14.5, 11]
解释：
第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。

提示：
节点值的范围在32位有符号整数范围内。
     */

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        bfs(list, ans);
        return ans;
    }

    private void bfs(List<TreeNode> list, List<Double> ans) {
        if (list.size() > 0) {
            List<TreeNode> newlist = new ArrayList<>();
            double sum = 0D;
            for (TreeNode t : list) {
                sum += t.val;
                if (t.left != null) {
                    newlist.add(t.left);
                }
                if (t.right != null) {
                    newlist.add(t.right);
                }
            }
            ans.add(sum / list.size());
            bfs(newlist, ans);
        }


    }
}
