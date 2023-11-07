package JavaAlgo.src.main.java.LinkList.SinglyLinkList.TextSinglyLinkList;

import JavaAlgo.src.main.java.LinkList.SinglyLinkList.SinglyLinkList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TextSinglyLinkList {

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
}
