package com.payne.leetCode.p_s;

import com.payne.leetCode.TreeNode;

import sun.reflect.generics.tree.Tree;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.p_s
 * Date       2020/09/04 - 14:32
 * Author     Payne.
 * About      类描述：
 */

public class P_897 {

    /**
     * 897. 递增顺序查找树
     * 给你一个树，请你 按中序遍历 重新排列树，
     * 使树中最左边的结点现在是树的根，
     * 并且每个结点没有左子结点，只有一个右子结点。
     * <p>
     * <p>
     * <p>
     * 示例 ：
     * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
     * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
     */

    /*
       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \
1        7   9

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9



        2
       / \
      1   3

      1
       \
        2
         \
          3
    * */
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            TreeNode ans = new TreeNode();
            ans.val = root.val;
            ans.right = increasingBST(root.right);
            return ans;
        } else {
            TreeNode ans = increasingBST(root.left);
            TreeNode tem = ans;
            while (tem != null) {
                if (tem.right == null) {
                    TreeNode t = new TreeNode();
                    t.val = root.val;
                    t.right = increasingBST(root.right);
                    tem.right = t;
                    break;
                }
                tem = tem.right;
            }
            return ans;
        }
    }
}
