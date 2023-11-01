package JavaAlgo.src.main.java.Queue.TextQueue;

import JavaAlgo.src.main.java.Queue.QueueImpl.LinkListQueue;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TextQueue {
    @Test
    public void offer() {
        LinkListQueue<Integer> queue = new LinkListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        assertIterableEquals(List.of(1,2,3),queue);
    }
}
