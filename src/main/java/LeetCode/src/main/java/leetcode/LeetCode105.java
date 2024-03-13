package LeetCode.src.main.java.leetcode;

import LeetCode.src.main.java.leetcode.Node.TreeNode;

import java.util.Arrays;

/**
 * 根据前序中序遍历的结果构造二叉树
 */
public class LeetCode105 {

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {

        if (preOrder.length == 0) {
            return null;
        }

        int rootValue = preOrder[0];
        TreeNode root = new TreeNode(rootValue);
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == rootValue) {

                int[] inLeft = Arrays.copyOfRange(inOrder,0,i);
                int[] inRight = Arrays.copyOfRange(inOrder,i + 1,inOrder.length);

                int[] preLeft = Arrays.copyOfRange(preOrder,1,i+1);
                int[] preRight = Arrays.copyOfRange(preOrder,i + 1,inOrder.length);

                root.left = buildTree(preLeft,inLeft);
                root.right = buildTree(preRight,inRight);
                break;
            }
        }
        return root;
    }

}
