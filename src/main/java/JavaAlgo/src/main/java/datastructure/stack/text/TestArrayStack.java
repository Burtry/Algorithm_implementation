package JavaAlgo.src.main.java.datastructure.stack.text;

import JavaAlgo.src.main.java.datastructure.stack.ArrayStack;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrayStack {

    @Test
    public void push() {
        ArrayStack<Object> stack = new ArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertFalse(stack.push(4));

        assertIterableEquals(List.of(3, 2, 1), stack);
    }

    @Test
    public void pop() {
        ArrayStack<Object> stack = new ArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertNull(stack.pop());
    }

    @Test
    public void pop2() {
        // 创建一个ArrayStack对象，容量为3
        ArrayStack<Object> stack = new ArrayStack<>(3);

        // 向栈中添加元素1、2和3
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // 弹出栈顶元素3
        assertEquals(3, stack.pop());

        // 向栈中添加元素4
        stack.push(4);

        // 检查栈中的元素顺序是否为4、2和1
        assertIterableEquals(List.of(4, 2, 1), stack);
    }






}
