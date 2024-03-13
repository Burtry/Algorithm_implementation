package JavaAlgo.src.main.java.datastructure.binarytree;


/**
 * 二叉树常用节点类
 */
public class TreeNodeString {
    public String  val;
    public TreeNodeString left;
    public TreeNodeString right;

    public TreeNodeString(String val) {
        this.val = val;
    }

    public TreeNodeString(TreeNodeString left, String  val, TreeNodeString right) {
        this.left = left;
        this.val = val;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
