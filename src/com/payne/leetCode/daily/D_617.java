package com.payne.leetCode.daily;

import com.payne.leetCode.TreeNode;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/09/23 - 10:29
 * Author     Payne.
 * About      类描述：
 */

class D_617 {

    /*https://leetcode-cn.com/problems/merge-two-binary-trees/
    * 617. 合并二叉树
给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

示例 1:

输入:
	Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7
输出:
合并后的树:
	     3
	    / \
	   4   5
	  / \   \
	 5   4   7
注意: 合并必须从两个树的根节点开始。
    * */

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 != null && t2 != null) {
            TreeNode ans = new TreeNode();
            ans.val = t1.val + t2.val;
            ans.left = mergeTrees(t1.left, t2.left);
            ans.right = mergeTrees(t1.right, t2.right);
            return ans;
        } else if (t1 != null) {
            return t1;
        } else {
            return t2;
        }
    }
}
