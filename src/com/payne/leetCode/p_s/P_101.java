package com.payne.leetCode.p_s;

import com.payne.leetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.p_s
 * Date       2020/08/21 - 11:54
 * Author     Payne.
 * About      类描述：
 */

class P_101 {

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     * <p>
     *  
     * <p>
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * <p>
     * 1
     * / \
     * 2   2
     * / \ / \
     * 3  4 4  3
     *  
     * <p>
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     * <p>
     * 1
     * / \
     * 2   2
     * \   \
     * 3    3
     *  
     * <p>
     * 进阶：
     * <p>
     * 你可以运用递归和迭代两种方法解决这个问题吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/symmetric-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 != null && t2 != null) {
            return t1.val == t2.val
                    && check(t1.left, t2.right)
                    && check(t2.left, t1.right);
        }
        return false;
    }

    //中序遍历
    public List<Integer> getMid(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            ans.add(null);
        } else if (root.left == null && root.right == null) {
            ans.add(root.val);
        } else {
            ans.add(root.val);
            ans.addAll(getMid(root.left));
            ans.addAll(getMid(root.right));
        }
        return ans;
    }
}
