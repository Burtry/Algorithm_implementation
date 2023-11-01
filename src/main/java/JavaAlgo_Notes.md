# JavaAlgo_Notes

## 队列

### 单向环形带哨兵的链表来实现队列

![69882882763](D:\develop\LeetCode_Algorithm-implementation\src\main\java\assets\1698828827634.png)





#### 初始化

实现步骤：（1）定义一个接口（提供队列的基本操作）

```
public interface Queue<E>，Iterable<E> {

    /**
     * 向队列尾部插入值
     * @param value 待插入值
     * @return 成功true 失败false
     */
    boolean offer(E value);

    /**
     * 从队列头获取值，并移除
     * @return 非空返回队列头部的值 否则返回null
     */
    E poll();

    /**
     * 从队列头获取值，不移除
     * @return 非空返回队列头部的值 否则返回null
     */

    E peek();

    /**
     * 检查队列是否为空
     * @return 空为true ,否则为false
     */
    boolean isEmpty();
}

```

**事项：**

**泛型的好处**

1.可以使用null值,使用null代表一些特殊值

2.可以代指更多的类型

**添加Iterable接口的用处**

1.方便迭代，方便测试

--------------------------------------------------------------------------------------------------------

（2）在链表类内定义一个结点类

```
/**
     * 定义节点类
     * @param <E> 元素类型
     */
    private static class Node<E> {
        //保存值的属性
        E value;
        //指向下一节点
        Node<E> next;

        //有参构造
        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
```

（3）根据需求在链表类中添加属性

```
/**
 * 单向环形带哨兵的链表方式实现队列
 * @param <E>
 */
public class LinkListQueue<E> implements Queue<E>,Iterable<E>{

    /**
     * 定义节点类
     * @param <E> 元素类型
     */
    private static class Node<E> {
        //保存值的属性
        E value;
        //指向下一节点
        Node<E> next;

        //有参构造
        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
    //头结点head  首先指向哨兵结点;
    Node<E> head = new Node<>(null,null);

    //尾结点tail  首先指向哨兵节点;
    Node<E> tail = head;

    //在构造方法里面，让tail.next 指向 head 来达成环形(环形链表，尾指向头部)


    public LinkListQueue() {
        tail.next = head;
    }

    @Override
    public boolean offer(E value) {
        
        return false;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
```

#### 实现各方法

offer方法 哨兵节点的next指向新节点，新节点的next指针指向头（哨兵）,tail指针指向新节点







