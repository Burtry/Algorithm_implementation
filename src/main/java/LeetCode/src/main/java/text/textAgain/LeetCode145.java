package LeetCode.src.main.java.text.textAgain;

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

        TreeNode curr = root;   //记录当前节点
        TreeNode pop = null; // 最近一次弹栈的元素

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
                //前
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null) {
                    //中
                    pop = stack.pop();
                    //后
                } else if (peek == pop) {
                    pop = stack.pop();
                } else {
                    //中
                    curr = peek.right;
                }
            }
        }
    }


}
