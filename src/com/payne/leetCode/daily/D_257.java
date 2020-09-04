package com.payne.leetCode.daily;

import com.payne.leetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/09/04 - 09:34
 * Author     Payne.
 * About      类描述：
 */

public class D_257 {

    /**
     * 257. 二叉树的所有路径
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 示例:
     * 输入:
     * 1
     * /   \
     * 2     3
     * \
     * 5
     * <p>
     * 输出: ["1->2->5", "1->3"]
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     */

    public List<String> binaryTreePaths(TreeNode root) {
        return bfs(root);
    }

    public List<String> bfs(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root != null) {
            if (root.left == null && root.right == null) {
                ans.add(root.val + "");
                return ans;
            } else {
                List<String> left = bfs(root.left);
                List<String> right = bfs(root.right);
                for (String s : left) {
                    ans.add(root.val + "->" + s);
                }
                for (String s : right) {
                    ans.add(root.val + "->" + s);
                }
            }
        }
        return ans;
    }
}
