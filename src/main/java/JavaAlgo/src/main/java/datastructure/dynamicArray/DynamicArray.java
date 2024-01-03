package JavaAlgo.src.main.java.datastructure.dynamicArray;

import java.util.Iterator;
import java.util.function.Consumer;

//动态数组
public class DynamicArray implements Iterable<Integer>{
    private int size = 0;   //元素个数或下一次存入位置
    private int capacity = 8;   //容量
    private int[] array = {};

    //添加元素
    public void addLast(int element) {
        add(size, element);
    }

    public void add(int index, int element) {
        CheckAndGrow();
        //添加
        if (index >= 0 && index <= size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    private void CheckAndGrow() {
        //容量检查
        if(size == 0) {
            array = new int[capacity];
        }else if(size == capacity) {
            //扩大1.5倍
            capacity = capacity + capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array,0,newArray,0,size);
            array = newArray;
        }
    }

    //遍历元素
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    //迭代器遍历
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }


    //删除元素
    public int remove(int index) {
        int removed = array[index];
        System.arraycopy(array,index + 1,array,index,size - index - 1);
        size--;
        return removed;
    }


}







