package com.payne.leetCode.daily;

import com.payne.leetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/09/14 - 17:07
 * Author     Payne.
 * About      类描述：
 */

class D_94 {

    /*
    * 94. 二叉树的中序遍历
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
    * */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (root.left != null) {
            List<Integer> list = inorderTraversal(root.left);
            ans.addAll(list);
        }
        ans.add(root.val);
        if (root.right != null) {
            List<Integer> list = inorderTraversal(root.right);
            ans.addAll(list);
        }
        return ans;
    }


}
