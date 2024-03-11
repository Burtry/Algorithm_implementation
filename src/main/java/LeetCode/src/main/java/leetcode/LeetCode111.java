package LeetCode.src.main.java.leetcode;

import LeetCode.src.main.java.leetcode.Node.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 二叉树最小深度
 */
public class LeetCode111 {

    //后序遍历求最小深度
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int d1 = minDepth(root.left);
        int d2 = minDepth(root.right);
        if (d1 == 0) {
            return d2 + 1;
        }
        if (d2 == 0) {
            return d1 + 1;
        }
        return Integer.min(d1,d2) + 1;
    }

    /**
     * 层序遍历求最小深度
     * 遇到的第一个叶子节点就是最小深度所在的层
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {

                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }

        }
        return depth;
    }

    @Test
    public void text1() {
        LeetCode111 leetCode104_2 = new LeetCode111();
        TreeNode root = new TreeNode(new TreeNode(2), 1, new TreeNode(null, 3, new TreeNode(4)));
        int i = leetCode104_2.minDepth2(root);

        assertEquals(2, i);
    }
}
