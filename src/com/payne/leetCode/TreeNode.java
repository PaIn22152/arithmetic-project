package com.payne.leetCode;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2020/08/07 - 09:31
 * Author     Payne.
 * About      类描述：
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
