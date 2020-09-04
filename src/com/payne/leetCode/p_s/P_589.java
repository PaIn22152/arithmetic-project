package com.payne.leetCode.p_s;

import com.payne.leetCode.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.p_s
 * Date       2020/09/04 - 14:23
 * Author     Payne.
 * About      类描述：
 */

public class P_589 {

    /**
     * 589. N叉树的前序遍历
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     * <p>
     * 例如，给定一个 3叉树 :
     * <p>
     * 返回其前序遍历: [1,3,5,6,2,4]。
     */
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root != null) {
            ans.add(root.val);
            for (Node n : root.children) {
                ans.addAll(preorder(n));
            }
        }
        return ans;
    }


}
