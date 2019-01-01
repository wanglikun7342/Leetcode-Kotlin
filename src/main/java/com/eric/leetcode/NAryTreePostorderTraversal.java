package com.eric.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePostorderTraversal {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorderInternal(result, root);
        return result;
    }

    private void postorderInternal(List<Integer> list, Node root) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            postorderInternal(list, child);
        }
        list.add(root.val);
    }
}
