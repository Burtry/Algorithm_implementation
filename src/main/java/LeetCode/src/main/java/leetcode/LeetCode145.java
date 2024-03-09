package LeetCode.src.main.java.leetcode;

import LeetCode.src.main.java.leetcode.Node.TreeNode;

import java.util.LinkedList;

/**
 * 二叉树前中后序遍历统一写法
 */
public class LeetCode145 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );

        LinkedList<TreeNode> stack = new LinkedList<>();  //创建栈用于存储来时的路

        TreeNode curr = root; // 代表当前节点
        TreeNode pop = null; // 最近一次弹栈的元素
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                // 待处理左子树
                System.out.println("前:" + curr.val);
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                // 没有右子树
                if (peek.right == null) {
                    System.out.println("中:" + peek.val);
                    pop = stack.pop();
                    System.out.println("后:" + pop.val);
                }
                // 右子树处理完成
                else if (peek.right == pop) {
                    pop = stack.pop();
                    System.out.println("后:" + pop.val);
                }
                // 待处理右子树
                else {
                    System.out.println("中:" + peek.val);
                    curr = peek.right;
                }
            }
        }
    }



}
