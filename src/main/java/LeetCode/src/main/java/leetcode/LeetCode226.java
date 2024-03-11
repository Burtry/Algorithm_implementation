package LeetCode.src.main.java.leetcode;

import LeetCode.src.main.java.leetcode.Node.TreeNode;

/**
 * 反转二叉树
 */
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        fun(root);
        return root;
    }


    private static void fun(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode left = node.left;
        node.left = node.right;
        node.right = left;

        fun(node.left);
        fun(node.right);
    }
}
