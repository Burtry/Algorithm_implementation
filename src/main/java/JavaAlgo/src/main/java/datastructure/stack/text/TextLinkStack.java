package JavaAlgo.src.main.java.datastructure.stack.text;

import JavaAlgo.src.main.java.datastructure.stack.LinkListStack;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TextLinkStack {
    @Test
    public void push() {
        LinkListStack<Object> stack = new LinkListStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertFalse(stack.push(4));

        assertIterableEquals(List.of(3, 2, 1), stack);
    }

    @Test
    public void pop() {
        LinkListStack<Object> stack = new LinkListStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // 3, 2, 1
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertNull(stack.pop());
    }
}
