package com.payne.leetCode;

import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2020/08/21 - 11:46
 * Author     Payne.
 * About      类描述：
 */

public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
