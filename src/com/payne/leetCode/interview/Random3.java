package com.payne.leetCode.interview;

import com.payne.leetCode.swordOffer.O_22;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.interview
 * Date       2020/08/06 - 10:02
 * Author     Payne.
 * About      类描述：
 */

public class Random3 {

    /**
     * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），
     * 请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
     * <p>
     * 示例:
     * 输入:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * 输出:  [1,2,4,7,5,3,6,8,9]
     * <p>
     * 说明:
     * 给定矩阵中的元素总数不会超过 100000 。
     */

    public int[] findDiagonalOrder(int[][] matrix) {

        //true   x++  y--
        //false  x--  y++
        boolean up = true;
        int x = 0, y = 0;
        int len = matrix.length * matrix[0].length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            if (up && y > 0) {
                x++;
                y--;
                res[i] = matrix[x][y];
            } else if (up && y <= 0 && x < matrix.length - 1) {
                up = false;
                x++;
                res[i] = matrix[x][y];
            } else if (!up && x > 0) {
                x--;
                y++;
                res[i] = matrix[x][y];
            } else if (!up && x <= 0 && y < matrix[0].length - 1) {
                up = true;
                y++;
                res[i] = matrix[x][y];
            } else if (up && y > 0 && x >= matrix.length - 1) {
                up = !up;
                y--;
                res[i] = matrix[x][y];
            } else if (!up && y >= matrix[0].length - 1) {
                up = !up;
                x++;
                res[i] = matrix[x][y];
            }
        }
        return res;
    }


    /**
     * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。
     * 由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。
     * 请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
     * 注意：要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。
     * 如果没有输出全部五个字母，那么它就不会发出声音。
     * 如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
     * <p>
     * 示例 1：
     * 输入：croakOfFrogs = "croakcroak"
     * 输出：1
     * 解释：一只青蛙 “呱呱” 两次
     * <p>
     * 示例 2：
     * 输入：croakOfFrogs = "crcoakroak"
     * 输出：2
     * 解释：最少需要两只青蛙，“呱呱” 声用黑体标注
     * 第一只青蛙 "crcoakroak"
     * 第二只青蛙 "crcoakroak"
     * <p>
     * 示例 3：
     * 输入：croakOfFrogs = "croakcrook"
     * 输出：-1
     * 解释：给出的字符串不是 "croak" 的有效组合。
     * <p>
     * 示例 4：
     * 输入：croakOfFrogs = "croakcroa"
     * 输出：-1
     * <p>
     * 提示：
     * 1 <= croakOfFrogs.length <= 10^5
     * 字符串中的字符只有 'c', 'r', 'o', 'a' 或者 'k'
     */

    public int minNumberOfFrogs(String croakOfFrogs) {

    }


    /**
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     * <p>
     * 示例 1:
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     * 解释:
     * 向右旋转 1 步: 5->1->2->3->4->NULL
     * 向右旋转 2 步: 4->5->1->2->3->NULL
     * 示例 2:
     * <p>
     * 输入: 0->1->2->NULL, k = 4
     * 输出: 2->0->1->NULL
     * 解释:
     * 向右旋转 1 步: 2->0->1->NULL
     * 向右旋转 2 步: 1->2->0->NULL
     * 向右旋转 3 步: 0->1->2->NULL
     * 向右旋转 4 步: 2->0->1->NULL
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode listNode=head;
        for (int i = 0; i < k; i++) {
            listNode = rotateRight(listNode);
        }
        return listNode;


    }

    public ListNode rotateRight(ListNode head) {
        ListNode tem = head;
        int v = 0;
        while (tem != null) {
            v = tem.val;
            tem = tem.next;
        }
        ListNode res = new ListNode(v);
        res.next = head;
        return res;
    }
}
