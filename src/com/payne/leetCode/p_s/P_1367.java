package com.payne.leetCode.p_s;

import com.payne.leetCode.ListNode;
import com.payne.leetCode.TreeNode;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.p_s
 * Date       2020/08/21 - 14:25
 * Author     Payne.
 * About      类描述：
 */

class P_1367 {

    /**
     * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
     * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，
     * 那么请你返回 True ，否则返回 False 。
     * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
     * <p>
     * 输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
     * 输出：true
     * 解释：树中蓝色的节点构成了与链表对应的子路径。
     * <p>
     * 提示：
     * 二叉树和链表中的每个节点的值都满足 1 <= node.val <= 100 。
     * 链表包含的节点数目在 1 到 100 之间。
     * 二叉树包含的节点数目在 1 到 2500 之间。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-in-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /*
    * [1,10]
      [1,null,1,10,1,9]
    * */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root != null) {
            if (head.val == root.val) {
                boolean c = check(head, root);
                if (c) {
                    return true;
                } else {
                    return isSubPath(head, root.left)
                            || isSubPath(head, root.right);
                }
            } else return isSubPath(head, root.left)
                    || isSubPath(head, root.right);
        }
        return false;
    }

    public boolean check(ListNode head, TreeNode root) {

        if (head == null) {
            return true;
        }
        if (root != null && head.val == root.val) {
            return check(head.next, root.left)
                    || check(head.next, root.right);
        }
        return false;

    }
}
