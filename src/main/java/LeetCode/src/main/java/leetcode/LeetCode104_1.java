package LeetCode.src.main.java.leetcode;

import LeetCode.src.main.java.leetcode.Node.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCode104_1 {

    public int maxDepth(TreeNode node) {
        if (node == null) {
            return  0;
        }
        //判断是否为叶子节点
        if (node.left == null && node.right == null) {
            return 1;
        }
        //递归调用得到左右子树的深度
        int d1 = maxDepth(node.left);
        int d2 = maxDepth(node.right);
        return Integer.max(d1, d2) + 1;
    }

    @Test
    public void text1() {
        LeetCode104_1 leetCode1041 = new LeetCode104_1();
        TreeNode root = new TreeNode(new TreeNode(2), 1, new TreeNode(null, 3, new TreeNode(4)));
        int i = leetCode1041.maxDepth(root);

        assertEquals(3, i);
    }

}
