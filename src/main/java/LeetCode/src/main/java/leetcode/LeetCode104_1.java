package LeetCode.src.main.java.leetcode;

import LeetCode.src.main.java.leetcode.Node.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/*
        思路：
        1. 得到左子树深度, 得到右子树深度, 二者最大者加一, 就是本节点深度
        2. 因为需要先得到左右子树深度, 很显然是后序遍历典型应用
        3. 关于深度的定义：从根(也可以是某节点)出发, 离根最远的节点总边数,
            注意: 力扣里的深度定义要多一

            深度2         深度3        深度1
            1            1            1
           / \          / \
          2   3        2   3
                            \
                             4
     */

public class LeetCode104_1 {

    //递归实现
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
