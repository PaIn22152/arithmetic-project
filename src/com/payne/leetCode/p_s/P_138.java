package com.payne.leetCode.p_s;

import java.util.HashMap;
import java.util.Map;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.p_s
 * Date       2021/02/22 - 10:25
 * Author     Payne.
 * About      类描述：
 */

class P_138 {
    /**
     * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，
     * 该指针可以指向链表中的任何节点或空节点。
     * <p>
     * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，
     * 其中每个新节点的值都设为其对应的原节点的值。
     * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，
     * 并使原链表和复制链表中的这些指针能够表示相同的链表状态。
     * 复制链表中的指针都不应指向原链表中的节点 。
     * <p>
     * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。
     * 那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
     * <p>
     * 返回复制链表的头节点。
     * <p>
     * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。
     * 每个节点用一个 [val, random_index] 表示：
     * val：一个表示 Node.val 的整数。
     * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
     * 你的代码 只 接受原链表的头节点 head 作为传入参数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (map.containsKey(head)) {
            return map.get(head);
        }

        Node node = new Node(head.val);
        map.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }

        //第一步，在每个原节点后面创建一个新节点
        Node tem = head;
        while (tem != null) {
            Node t = new Node(tem.val);
            t.next = tem.next;
            tem.next = t;
            tem = tem.next.next;
        }

        //第二步，设置新节点的随机节点
        tem = head;
        while (tem != null) {
            if (tem.random != null) {
                tem.next.random = tem.random.next;
            }
            tem = tem.next.next;
        }

        //第三步，将两个链表分离
        Node dummy = new Node(-1);
        tem = head;
        Node cur = dummy;
        while (tem != null) {
            cur.next = tem.next;
            cur = cur.next;
            tem.next = cur.next;
            tem = tem.next;
        }
        return dummy.next;
    }
}
