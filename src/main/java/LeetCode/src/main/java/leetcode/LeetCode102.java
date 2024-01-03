package LeetCode.src.main.java.leetcode;

import JavaAlgo.src.main.java.datastructure.queue.QueueImpl.LinkListQueue;
import LeetCode.src.main.java.leetcode.Node.TreeNode;

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
        int c1 = 1; //当前层的节点数
        while (!queue.isEmpty()) {
            int c2 = 0; //下一层节点数
            for (int i = 0; i < c1; i++) {
                TreeNode node = queue.poll();
                System.out.print(node + " ");
                if (node.left != null) {
                    queue.offer(node.left);
                    c2++;
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    c2++;
                }
            }
            //换行
            System.out.println();
            c1 = c2;

        }
    }
}
