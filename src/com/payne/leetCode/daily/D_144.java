package com.payne.leetCode.daily;

import com.payne.leetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/10/27 - 18:43
 * Author     Payne.
 * About      类描述：
 */

class D_144 {

    /*https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
    * 144. 二叉树的前序遍历
给定一个二叉树，返回它的 前序 遍历。

 示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,2,3]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

前序遍历：根结点 ---> 左子树 ---> 右子树
    * */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        handle(root, ans);
        return ans;
    }

    private void handle(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            handle(root.left, list);
            handle(root.right, list);
        }
    }
}
