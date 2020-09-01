package com.payne.leetCode.interview;

import com.payne.leetCode.TreeNode;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.interview
 * Date       2020/08/31 - 18:55
 * Author     Payne.
 * About      类描述：
 */

class I_04 {

    /**
     * 面试题 04.04. 检查平衡性
     * 实现一个函数，检查二叉树是否平衡。
     * 在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
     * <p>
     * 示例 1:
     * 给定二叉树 [3,9,20,null,null,15,7]
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回 true 。
     * 示例 2:
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     * 1
     * / \
     * 2   2
     * / \
     * 3   3
     * / \
     * 4   4
     * 返回 false 。
     */

    //[1,2,2,3,3,null,null,4,4]
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            return isBalanced(root.left) && isBalanced(root.right)
                    && Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1;
        }
        if (root.left == null) {
            return root.right.left == null && root.right.right == null;
        } else {
            return root.left.left == null && root.left.right == null;
        }
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(getDepth(root.left), getDepth(root.right));
        }
    }
}
