package com.payne.leetCode.daily;

import com.payne.leetCode.TreeNode;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/08/17 - 09:33
 * Author     Payne.
 * About      类描述：
 */

class D_110 {

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     * <p>
     * 示例 1:
     * 给定二叉树 [3,9,20,null,null,15,7]
     * 返回 true 。
     * <p>
     * 示例 2:
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     * 返回 false 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /*
    示例 1:
     给定二叉树 [3,9,20,null,null,15,7]
      3
     / \
    9  20
      /  \
     15   7



     示例 2:
     给定二叉树 [1,2,2,3,3,null,null,4,4]
         1
        / \
       2   2
      / \
     3   3
    / \
   4   4
    * */
//    public boolean isBalanced(TreeNode root) {
//        if (root == null) return true;
//        return isBalanced(root.left)
//                && isBalanced(root.right)
//                && Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1;
//    }


    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.right != null) {
            return isBalanced(root.left)
                    && isBalanced(root.right)
                    && Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1;
        } else if (root.left == null) {
            return getDepth(root.right) <= 1;
        } else {
            return getDepth(root.left) <= 1;
        }
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(1 + getDepth(root.left), 1 + getDepth(root.right));
    }


    //官方代码
    public boolean isBalanced2(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
