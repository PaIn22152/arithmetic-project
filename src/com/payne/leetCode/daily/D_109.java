package com.payne.leetCode.daily;

import com.payne.leetCode.ListNode;
import com.payne.leetCode.TreeNode;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/08/18 - 09:26
 * Author     Payne.
 * About      类描述：
 */

class D_109 {

    /**
     * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
     * <p>
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     * <p>
     * 示例:
     * 给定的有序链表： [-10, -3, 0, 5, 9],
     * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /*
        0
       / \
     -3   9
     /   /
   -10  5
    * */

    //[1,2,3,4,5,null]
    //[1,2,3,4,null]
    //[1,2,3,null]
    //[1,null]
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode tem = head;
        ListNode right = head;
        int len = 0, leftLen, rightPosition = 0;
        while (tem != null) {
            tem = tem.next;
            len++;
            if (tem != null) {
                tem = tem.next;
                len++;
            }
            right = right.next;
            rightPosition++;
        }
        leftLen = len - 1 - (len-rightPosition);

        tem = head;
        int p = 0;
        int value = -1;
        ListNode left = null;
        while (tem != null) {
            if (p < leftLen) {
                ListNode l = new ListNode(tem.val);
                l.next = left;
                left = l;
            }

            if (p == rightPosition - 1) {
                value = tem.val;
            }
            tem = tem.next;
            p++;
        }
        left = reverse(left);
        return new TreeNode(value, sortedListToBST(left), sortedListToBST(right));
    }


    private ListNode reverse(ListNode head) {
        ListNode l1 = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tem = new ListNode(curr.val);
            tem.next = l1;
            l1 = tem;
            curr = curr.next;
        }
        return l1;
    }
    /**
     *  思考过程
     *  需要将链表转成高度平衡的二叉搜索树，找到链表的中间节点，作为二叉树的根，前部分作为左节点，后部分作为右节点
     *  然后递归，直到链表长度为1或者为空时，可以返回确定的二叉树
     *
     *  可以使用快慢双指针，找到链表的中间节点，和后部分链表
     *  前部分链表可以从head开始构建链表，然后再翻转
     *
     * */


    //官方解法
    public TreeNode sortedListToBST2(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }



    //解题思路和代码和我类似，不同的是找前链表，效率比我的方式高
    /*
    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    内存消耗：41 MB, 在所有 Java 提交中击败了46.77%的用户
    * */
    public TreeNode sortedListToBST3(ListNode head) {
        //边界条件的判断
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);
        //这里通过快慢指针找到链表的中间结点slow，pre就是中间
        //结点slow的前一个结点
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //链表断开为两部分，一部分是node的左子节点，一部分是node
        //的右子节点
        pre.next = null;
        //node就是当前节点
        TreeNode node = new TreeNode(slow.val);
        //从head节点到pre节点是node左子树的节点
        node.left = sortedListToBST3(head);
        //从slow.next到链表的末尾是node的右子树的结点
        node.right = sortedListToBST3(slow.next);
        return node;
    }


}
