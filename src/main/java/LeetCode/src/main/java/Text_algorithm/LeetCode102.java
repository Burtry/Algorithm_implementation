package LeetCode.src.main.java.Text_algorithm;

import JavaAlgo.src.main.java.Queue.QueueImpl.LinkListQueue;
import JavaAlgo.src.main.java.Queue.TextQueue.LinkedListQueue;
import LeetCode.src.main.java.Text_algorithm.Node.TreeNode;

import java.util.concurrent.LinkedTransferQueue;

/**
 * 二叉树层序遍历
 */
public class LeetCode102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7)
                )

        );

        LinkListQueue<TreeNode> queue = new LinkListQueue<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node);
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
}
