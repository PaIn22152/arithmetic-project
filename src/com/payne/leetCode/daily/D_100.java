package com.payne.leetCode.daily;

import com.payne.leetCode.TreeNode;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/08/07 - 09:32
 * Author     Payne.
 * About      类描述：
 */

class D_100 {

    /**
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * 示例 1:
     * 输入:       1         1
     * / \       / \
     * 2   3     2   3
     * [1,2,3],   [1,2,3]
     * 输出: true
     * <p>
     * 示例 2:
     * 输入:      1          1
     * /           \
     * 2             2
     * [1,2],     [1,null,2]
     * 输出: false
     * <p>
     * 示例 3:
     * 输入:       1         1
     * / \       / \
     * 2   1     1   2
     * [1,2,1],   [1,1,2]
     * 输出: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/same-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {//两个都为空，true
            return true;
        } else if (p != null && q != null) {
            //两个都非空，比较值是否相等，然后再分别比较左右节点
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else return false;//一个空，一个非空，false
    }
}
