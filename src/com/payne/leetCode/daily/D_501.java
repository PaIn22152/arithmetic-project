package com.payne.leetCode.daily;

import com.payne.leetCode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/09/24 - 19:09
 * Author     Payne.
 * About      类描述：
 */

class D_501 {
    /*
    * 501. 二叉搜索树中的众数
给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

假定 BST 有如下定义：

结点左子树中所含结点的值小于等于当前结点的值
结点右子树中所含结点的值大于等于当前结点的值
左子树和右子树都是二叉搜索树
例如：
给定 BST [1,null,2,2],

   1
    \
     2
    /
   2
返回[2].

提示：如果众数超过1个，不需考虑输出顺序

进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内
    * */

    int max = 0;

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        max = 0;
        handle(root, map);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private void handle(TreeNode root, Map<Integer, Integer> map) {
        if (root != null) {
            if (map.containsKey(root.val)) {
                int v = map.get(root.val) + 1;
                max = Math.max(max, v);
                map.put(root.val, v);
            } else {
                max = Math.max(max, 1);
                map.put(root.val, 1);
            }
            handle(root.left, map);
            handle(root.right, map);
        }
    }
}
