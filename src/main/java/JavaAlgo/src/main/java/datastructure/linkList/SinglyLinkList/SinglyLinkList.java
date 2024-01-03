package JavaAlgo.src.main.java.datastructure.linkList.SinglyLinkList;

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
    public void addFirst(int value) {
        /*//1链表为空
        head = new Node(value,null); */   //将头指针指向新节点(将新节点的引用值赋值给head)
        //2.链表非空
        head = new Node(value,head);
    }
    /**
     * 遍历链表
     * @param consumer
     */
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
    //迭代器遍历增强for循环 重写迭代器对象
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


    //递归遍历

    public void loop3(Consumer<Integer> before, Consumer<Integer> after) {
        recursion(head, before, after);
    }

    private void recursion(Node curr,
                   Consumer<Integer> before, Consumer<Integer> after) {
        if (curr == null) {
            return;
        }
        before.accept(curr.value);
        recursion(curr.next, before, after);
        after.accept(curr.value);
    }

    /**
     * 向链表尾部添加
     * @param value 待添加值
     */
    //向最后的节点后添加节点
    public void addLast(int value) {
        Node last = findLast();
        if(last ==null) {
            addFirst(value);
            return;
        }
        last.next = new Node(value,null);
    }
    //查找最后一个节点
    private Node findLast(){
        if(head ==null){//空链表
            return null;
        }
        Node p = head;
        while (p.next != null){
            p = p.next;
        }
        return p;
    }
    /**
     * 根据索引返回节点中的值
     * @param index -索引
     * @return 找到返回该索引位置的值
     * @throws IllegalArgumentException 找不到抛出index异常
     */
    public int get(int index) throws IllegalArgumentException{
        Node node = findNode(index);
        if(node ==null) throw new IllegalArgumentException(String.format("index[%d] 不合法%n",index));
        return node.value;
    }
    //根据索引返回索引处的节点
    private Node findNode(int index) {
        int i = 0;
        for (Node p = head;p !=null;p = p.next,i++){
            if(i ==index) return p;
        }
        return null;
    }
    /**
     * 向索引位置插入
     * @param index -索引
     * @param value -待插入的值
     * @throws IllegalArgumentException 找不到抛出index异常
     */
    public void insert(int index, int value) throws IllegalArgumentException{
        if(index ==0){
            addFirst(value);
            return;
        }

        Node node = findNode(index - 1);//找到上一个节点
        if(node ==null) {//找不到
            throw new IllegalArgumentException(String.format("index[%d] 不合法%n",index));
        }
        node.next = new Node(value,node.next);
    }
    /**
     * 删除第一个节点
     * @throws IllegalArgumentException 如果不存在，抛出IllegalArgumentException异常
     */
    public void removeFirst() throws IllegalArgumentException{
        if(head.next == null){
            throw new IllegalArgumentException();
        }
        head = head.next;
    }
    /**
     * 删除索引位置的节点
     * @param index -索引
     * @throws IllegalArgumentException 找不到抛出异常
     */
    public void remove(int index) throws IllegalArgumentException{
        if(index ==0){
            removeFirst();
        }

        Node prev = findNode(index - 1);
        if(prev ==null){
            throw new IllegalArgumentException(String.format("index[%d] 不合法%n",index));
        }
        Node removed = prev.next;
        if(removed ==null){
            throw new IllegalArgumentException(String.format("index[%d] 不合法%n",index));
        }
         prev.next= removed.next;
    }
}


