package JavaAlgo.src.main.java.LinkList.SinglyLinkList;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单向链表
 */
public class SinglyLinkList implements Iterable<Integer>{
    Node head;  //头指针

    /**
     * 节点类
     */
    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 头插不带头结点
     * @param value 待添加的值
     */

    public void addFirst(int value) {
        /*//1链表为空
        head = new Node(value,null); */   //将头指针指向新节点(将新节点的引用值赋值给head)
        //2.链表非空
        head = new Node(value,head);
    }

    //遍历链表 while循环
    public void loop1(Consumer<Integer> consumer) {
        Node p = head;
        while (p != null) {
            //对于链表的操作最好由参数传入尽进来,具体要怎么用，由调用放进行决定
            consumer.accept(p.value);
            p = p.next;
        }
    }
    //for循环
    public void loop2(Consumer<Integer> consumer) {
        for(Node p = head; p != null;p = p.next){
            consumer.accept(p.value);
        }
    }
    //迭代器遍历增强for循环
    //重写迭代器对象
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head;
            @Override
            public boolean hasNext() {  //询问是否有下一个元素
                return p != null;
            }

            @Override
            public Integer next() {     //返回当前元素的值，并指向下一个元素
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}


