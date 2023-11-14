package JavaAlgo.src.main.java.LinkList.SinglyLinkList.TextSinglyLinkList;

import JavaAlgo.src.main.java.LinkList.SinglyLinkList.SinglyLinkList;
import JavaAlgo.src.main.java.LinkList.SinglyLinkList.SinglyLinkListSentinel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TextSinglyLinkList {

    private static SinglyLinkListSentinel getSinglyListSentinel(){
        SinglyLinkListSentinel singlyLinkList = new SinglyLinkListSentinel();
        singlyLinkList.addLast(1);
        singlyLinkList.addLast(2);
        singlyLinkList.addLast(3);
        singlyLinkList.addLast(4);
        return singlyLinkList;
    }


    @Test
    public void text1() {
        SinglyLinkList singlyLinkList = new SinglyLinkList();
        singlyLinkList.addFirst(1);
        singlyLinkList.addFirst(2);
        singlyLinkList.addFirst(3);
        singlyLinkList.loop1(value -> {
            //System.out::println
            System.out.println(value);
        });

        singlyLinkList.loop2(value-> {
            System.out.println(value);
        });

    }

    @Test
    public void text2() {
        SinglyLinkList singlyLinkList = new SinglyLinkList();
        singlyLinkList.addFirst(1);
        singlyLinkList.addFirst(2);
        singlyLinkList.addFirst(3);
        for (Integer value : singlyLinkList) {
            System.out.println(value);
        }
    }

    @Test
    public void text3() {
        SinglyLinkList singlyLinkList = new SinglyLinkList();
        singlyLinkList.addLast(1);
        singlyLinkList.addLast(2);
        singlyLinkList.addLast(3);

        singlyLinkList.insert(2,4);
        for (Integer i : singlyLinkList) {
            System.out.println(i);
        }

    }

    @Test
    @DisplayName("测试insert")
    public void text4(){
        SinglyLinkListSentinel list = getSinglyListSentinel();
        list.insert(0,5);
        assertIterableEquals(List.of(5,1,2,3,4),list);

        list = getSinglyListSentinel();
        list.addFirst(5);
        assertIterableEquals(List.of(5,1,2,3,4),list);

        SinglyLinkListSentinel linkListSentinel = new SinglyLinkListSentinel();
        linkListSentinel.addFirst(1);
        assertIterableEquals(List.of(1),linkListSentinel);
    }

    @Test
    @DisplayName("测试remove")
    public void text5(){
        SinglyLinkListSentinel singlyListSentinel = getSinglyListSentinel();
        singlyListSentinel.remove(2);
        assertIterableEquals(List.of(1,2,4),singlyListSentinel);
        singlyListSentinel.remove(0);
        assertIterableEquals(List.of(2,4),singlyListSentinel);
        singlyListSentinel.removeFirst();
        assertIterableEquals(List.of(4),singlyListSentinel);
        singlyListSentinel.removeFirst();
        assertIterableEquals(List.of(),singlyListSentinel);
        assertThrows(IllegalArgumentException.class,singlyListSentinel::removeFirst);

        assertThrows(IllegalArgumentException.class,()->singlyListSentinel.remove(5));
        assertThrows(IllegalArgumentException.class,()->singlyListSentinel.remove(7));

    }
}
