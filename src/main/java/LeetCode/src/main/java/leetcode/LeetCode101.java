package LeetCode.src.main.java.leetcode;

import LeetCode.src.main.java.leetcode.Node.TreeNode;

/**
 * 对称二叉树
 */
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        //两边都为null对称
        if (left == null && right == null) {
            return true;
        }
        //一边为null不对称
        if (left == null || right == null) {
            return false;
        }
        //值不相等不对称
        if (left.val != right.val) {
            return false;
        }
        //递归check
        return check(left.left,right.right) && check(left.right, right.left);
    }
}
