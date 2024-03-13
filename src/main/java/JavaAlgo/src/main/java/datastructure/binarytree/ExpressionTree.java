package JavaAlgo.src.main.java.datastructure.binarytree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 根据后缀表达式构造表达式树
 */

//表达树的后序遍历就是后缀表达式

public class ExpressionTree {

    /**
     * 思路       1.遇到数字入栈
     *           2.遇到运算符, 出栈两次, 与当前节点建立父子关系, 当前节点入栈
     * @param tokens 后缀表达式
     * @return 根结点
     */
    public TreeNodeString constructExpressionTree(String[] tokens) {
        LinkedList<TreeNodeString> stack = new LinkedList<>();
        for (String token : tokens) {
            switch (token) {
                case "+","-","*","/" -> {
                    //运算符
                    TreeNodeString parent = new TreeNodeString(token);
                    //先弹出的为右孩子
                    parent.right = stack.pop();
                    parent.left = stack.pop();
                    stack.push(parent);
                }
                default -> //数字
                        stack.push(new TreeNodeString(token));
            }
        }
        return stack.peek();
    }


}
