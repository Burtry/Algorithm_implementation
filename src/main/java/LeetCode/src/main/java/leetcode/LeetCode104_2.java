package LeetCode.src.main.java.leetcode;

import LeetCode.src.main.java.leetcode.Node.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
        思路：
        1. 使用非递归后序遍历, 栈的最大高度即为最大深度
     */
public class LeetCode104_2 {
    //非递归实现
    public int maxDepth(TreeNode node) {
        TreeNode curr = node;
        //记录最后一次弹栈的节点
        TreeNode pop = null;
        //栈的最大高度
        int max = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (curr != null || !stack.isEmpty()) {
            //处理左子树
            if (curr != null) {
                stack.push(curr);
                int size = stack.size();
                if (size > max) {
                    max = size;
                }
                curr = curr.left;

            }
            //处理右子树
            else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop) {
                    pop = stack.pop();
                } else {
                    curr = peek.right;
                }
            }
        }
        return max;
    }

    @Test
    public void text1() {
        LeetCode104_2 leetCode104_2 = new LeetCode104_2();
        TreeNode root = new TreeNode(new TreeNode(2), 1, new TreeNode(null, 3, new TreeNode(4)));
        int i = leetCode104_2.maxDepth(root);

        assertEquals(3, i);
    }

}
