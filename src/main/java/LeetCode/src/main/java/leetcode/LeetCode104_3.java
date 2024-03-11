package LeetCode.src.main.java.leetcode;

import LeetCode.src.main.java.leetcode.Node.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 层序遍历 求最大深度
 */
public class LeetCode104_3 {
    //非递归实现
    public int maxDepth(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            depth++;
        }
        return depth;
    }

    @Test
    public void text1() {
        LeetCode104_3 leetCode104_2 = new LeetCode104_3();
        TreeNode root = new TreeNode(new TreeNode(2), 1, new TreeNode(null, 3, new TreeNode(4)));
        int i = leetCode104_2.maxDepth(root);

        assertEquals(3, i);
    }

}
