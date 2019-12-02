package com.payne.leetCode.p_s;

/**
 * Created by payne on 2018-01-07.
 * About 类描述：
 * Given two binary trees and imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.
 You need to merge them into a new binary tree.
 The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
 Otherwise, the NOT null node will be used as the node of new tree.
 */
public class P_617_MergeTwoBinaryTrees {

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		return my(t1, t2);
	}

	public TreeNode my(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return null;
		}
		if (t1 == null) {
			return t2;
		}
		if (t2 == null) {
			return t1;
		}
		t1.val = t1.val + t2.val;
		t1.left = my(t1.left, t2.left);
		t1.right = my(t1.right, t2.right);
		return t1;

	}

	public static class TreeNode {
		int val;

		TreeNode left;

		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
