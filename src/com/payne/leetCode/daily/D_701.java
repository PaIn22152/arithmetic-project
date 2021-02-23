package com.payne.leetCode.daily;

import com.payne.leetCode.TreeNode;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/09/30 - 09:49
 * Author     Payne.
 * About      类描述：
 */

class D_701 {

    /*
    * 701. 二叉搜索树中的插入操作
给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。

注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。



例如,

给定二叉搜索树:

        4
       / \
      2   7
     / \
    1   3

和 插入的值: 5
你可以返回这个二叉搜索树:

         4
       /   \
      2     7
     / \   /
    1   3 5
或者这个树也是有效的:

         5
       /   \
      2     7
     / \
    1   3
         \
          4


提示：

给定的树上的节点数介于 0 和 10^4 之间
每个节点都有一个唯一整数值，取值范围从 0 到 10^8
-10^8 <= val <= 10^8
新值和原始二叉搜索树中的任意节点值都不同
    * */

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode();
            root.val = val;
            return root;
        }
        handle(root, val);
        return root;
    }

    private void handle(TreeNode root, int val) {
        if (root != null) {
            if (root.val > val) {
                if (root.left == null) {
                    TreeNode t = new TreeNode();
                    t.val = val;
                    root.left = t;
                } else {
                    handle(root.left, val);
                }
            } else if (root.val < val) {
                if (root.right == null) {
                    TreeNode t = new TreeNode();
                    t.val = val;
                    root.right = t;
                } else {
                    handle(root.right, val);
                }
            }
        }
    }
}
