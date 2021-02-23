package com.payne.leetCode.daily;

import com.payne.leetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/09/29 - 09:34
 * Author     Payne.
 * About      类描述：
 */

class D_145 {

    /*
    https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
145. 二叉树的后序遍历
给定一个二叉树，返回它的 后序 遍历。
示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3
输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
后序遍历：左子树 ---> 右子树 ---> 根结点
    * */

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root != null) {
            ans.addAll(postorderTraversal(root.left));
            ans.addAll(postorderTraversal(root.right));
            ans.add(root.val);
        }
        return ans;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {

    }
}
