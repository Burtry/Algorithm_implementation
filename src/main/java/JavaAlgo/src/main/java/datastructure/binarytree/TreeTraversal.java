package JavaAlgo.src.main.java.datastructure.binarytree;

//递归实现深度优先遍历
public class TreeTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();

    }

    /**
     * <h3>前序遍历</h3>
     * @param node
     */
    static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node + "\t");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * <h3>中序遍历</h3>
     * @param node
     */
    static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node + "\t");
        inOrder(node.right);
    }

    /**
     * <h3>后续遍历</h3>
     * @param node
     */
    static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node + "\t");
    }
}
