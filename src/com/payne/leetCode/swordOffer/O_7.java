package com.payne.leetCode.swordOffer;

import com.payne.leetCode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.swordOffer
 * Date       2020/08/10 - 15:16
 * Author     Payne.
 * About      类描述：
 */

public class O_7 {

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * <p_old>
     * 例如，给出
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     * <p_old>
     * <p_old>
     * 限制：
     * 0 <= 节点个数 <= 5000
     * <p_old>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /*
    二叉树
          3
         / \
        9  20
          /  \
         15   7
         preorder = [3,9,20,15,7]
         inorder  = [9,3,15,20,7]

         二叉树2
           1
         /   \
        2     3
       / \   /  \
      4  5  6    7
      preorder =  [1,2,4,5,3,6,7]
      inorder  =  [4,2,5,1,6,3,7]


      二叉树3
          1
         /
        2
      /  \
     3    4
     preorder =  [1,2,3,4]
     inorder  =  [3,2,4,1]

      二叉树4
          1
         /
        2
        pre=[1,2]
        in =[2,1]

         二叉树5
          1
           \
            2
        pre=[1,2]
        in =[1,2]


         二叉树4
          1
         / \
        2   3
        pre=[1,2,3]
        in =[2,1,3]

    */

    /**
     * 题解
     * 分治思想
     * 当遍历长度小于等于1时，可以直接确定树的结构
     * 当遍历长度大于1时，找到左右节点的遍历，然后递归
     */
    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length < 1 || preorder.length != inorder.length) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        //可以注释掉
//        if (preorder.length == 2) {
//            TreeNode res = new TreeNode(preorder[0]);
//            if (preorder[0] == inorder[0]) {
//                res.right = new TreeNode(preorder[1]);
//            } else {
//                res.left = new TreeNode(preorder[1]);
//            }
//            return res;
//        }

        TreeNode head = new TreeNode(preorder[0]);
        int[] leftPre = null;
        int[] rightPre = null;
        int[] leftIn = null;
        int[] rightIn = null;
        int headVal = preorder[0];
        int leftLen = 0;
        int rightLen = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (headVal == inorder[i]) {
                leftLen = i;
                rightLen = inorder.length - leftLen - 1;
                break;
            }
        }
        if (leftLen > 0) {
            leftPre = new int[leftLen];
            leftIn = new int[leftLen];
        }
        if (rightLen > 0) {
            rightPre = new int[rightLen];
            rightIn = new int[rightLen];
        }
        for (int i = 1; i < preorder.length; i++) {
            if (i <= leftLen) {
                leftPre[i - 1] = preorder[i];
            }
            if (i > leftLen) {
                rightPre[i - 1 - leftLen] = preorder[i];
            }
        }
        for (int i = 0; i < inorder.length; i++) {
            if (i < leftLen) {
                leftIn[i] = inorder[i];
            }
            if (i > leftLen) {
                rightIn[i - 1 - leftLen] = inorder[i];
            }
        }
        head.left = buildTree3(leftPre, leftIn);
        head.right = buildTree3(rightPre, rightIn);
        return head;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        for (int i : preorder) {
            pre.add(i);
        }
        for (int i : inorder) {
            in.add(i);
        }
        return buildTree2(pre, in);
    }


    //比直接用 int[] 更耗时
    public TreeNode buildTree2(List<Integer> preorder, List<Integer> inorder) {
        if (preorder == null || preorder.size() < 1 || preorder.size() != inorder.size()) {
            return null;
        }
        if (preorder.size() == 1) {
            return new TreeNode(preorder.get(0));
        }
        if (preorder.size() == 2) {
            TreeNode res = new TreeNode(preorder.get(0));
            if (preorder.get(0).equals(inorder.get(0))) {
                res.right = new TreeNode(preorder.get(1));
            } else {
                res.left = new TreeNode(preorder.get(1));
            }
            return res;
        }

        TreeNode head = new TreeNode(preorder.get(0));
        List<Integer> leftPre = null;
        List<Integer> rightPre = null;
        List<Integer> leftIn = null;
        List<Integer> rightIn = null;
        int headVal = preorder.get(0);
        int leftLen = 0;
        int rightLen = 0;
        for (int i = 0; i < inorder.size(); i++) {
            if (headVal == inorder.get(i)) {
                leftLen = i;
                rightLen = inorder.size() - leftLen - 1;
                break;
            }
        }
        if (leftLen > 0) {
            leftPre = preorder.subList(1, leftLen + 1);
            leftIn = inorder.subList(0, leftLen);
        }
        if (rightLen > 0) {
            rightPre = preorder.subList(leftLen + 1, preorder.size());
            rightIn = inorder.subList(leftLen + 1, preorder.size());
        }

        head.left = buildTree2(leftPre, leftIn);
        head.right = buildTree2(rightPre, rightIn);
        return head;
    }


    //官方代码，相比于我自己的代码，不会每次都创建4个int[]对象，所以效率更高
    public TreeNode buildTree_(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd,
                              int[] inorder, int inorderStart, int inorderEnd,
                              Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        if (preorderStart == preorderEnd) {
            return root;
        } else {
            int rootIndex = indexMap.get(rootVal);
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes,
                    inorder, inorderStart, rootIndex - 1,
                    indexMap);
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd,
                    inorder, rootIndex + 1, inorderEnd,
                    indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }
    }


    /**
     * 四种主要的遍历思想为：
     * 前序遍历：根结点 ---> 左子树 ---> 右子树
     * 中序遍历：左子树---> 根结点 ---> 右子树
     * 后序遍历：左子树 ---> 右子树 ---> 根结点
     * 层次遍历：只需按层次遍历即可
     *
     *
     * 二叉树的前序遍历顺序是：根节点、左子树、右子树，每个子树的遍历顺序同样满足前序遍历顺序。
     * 二叉树的中序遍历顺序是：左子树、根节点、右子树，每个子树的遍历顺序同样满足中序遍历顺序。
     *
     * */
}
