# JavaAlgo_Notes

## 队列

### 单向环形带哨兵的链表来实现队列

实现步骤：

1.定义一个接口（提供队列的基本操作）

```
public interface Queue<E> {

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





