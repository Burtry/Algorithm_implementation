package LeetCode.src.main.java.leetcode;

import JavaAlgo.src.main.java.datastructure.stack.LinkListStack;
import LeetCode.src.main.java.leetcode.Node.TreeNode;

import java.util.LinkedList;

/**
 * 二叉树前序遍历
 */
public class LeetCode144 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );

        LinkedList<TreeNode> stack = new LinkedList<>();  //创建栈用于存储来时的路

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                System.out.println("来" + curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            else {
                TreeNode pop = stack.pop();
                System.out.println("回" + pop.val);
                curr = pop.right;
            }

        }
    }



}
