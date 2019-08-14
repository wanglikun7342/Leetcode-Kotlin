package com.eric.leetcode;

public class SerializeAndDeserializeBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        if (root.left == null && root.right == null)
            return root.val + "";
        else if (root.left == null)
            return root.val + "()" + "(" + serialize(root.right) + ")";
        else if (root.right == null)
            return root.val + "(" + serialize(root.left) + ")";
        return root.val + "(" + serialize(root.left) + ")" + "(" + serialize(root.right) + ")";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
        if (s == null || s.length() == 0) return null;

        int firstParen = s.indexOf("(");
        int val = firstParen == -1 ?  Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstParen));
        TreeNode cur = new TreeNode(val);

        if (firstParen == -1) return cur;

        int start = firstParen, leftParenCount = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '(') leftParenCount++;
            else if (s.charAt(i) == ')') leftParenCount--;

            if (leftParenCount == 0 && start == firstParen)  {
                cur.left = deserialize(s.substring(start + 1, i));
                start = i + 1;
            } else if (leftParenCount == 0) {
                cur.right = deserialize(s.substring(start + 1, i));
            }
        }
        return cur;
    }

    public static void main(String args[]) {

    }
}