package com.payne.leetCode.daily;

import com.payne.leetCode.TreeNode;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/09/25 - 18:02
 * Author     Payne.
 * About      类描述：
 */

public class D_106 {

    /*
    * 106. 从中序与后序遍历序列构造二叉树
根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
    * */

    //[9,3,15,20,7]
    //[9,15,7,20,3]
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len > 0) {
            TreeNode ans = new TreeNode();
            int value = postorder[postorder.length - 1];
            ans.val = value;

            int leftLen = 0;
            int rightLen = 0;
            for (int i = 0; i < len; i++) {
                if (value == inorder[i]) {
                    leftLen = i;
                    rightLen = len - leftLen - 1;
                    break;
                }
            }

            int[] leftI = new int[leftLen];
            int[] rightI = new int[rightLen];
            for (int i = 0; i < len; i++) {
                if (i < leftLen) {
                    leftI[i] = inorder[i];
                } else if (i > leftLen) {
                    rightI[i - leftLen - 1] = inorder[i];
                }
            }

            int[] leftP = new int[leftLen];
            int[] rightP = new int[rightLen];
            for (int i = 0; i < len - 1; i++) {
                if (i < leftLen) {
                    leftP[i] = postorder[i];
                } else {
                    rightP[i - leftLen] = postorder[i];
                }
            }

            ans.left = buildTree(leftI, leftP);
            ans.right = buildTree(rightI, rightP);
            return ans;

        } else return null;

    }


}
