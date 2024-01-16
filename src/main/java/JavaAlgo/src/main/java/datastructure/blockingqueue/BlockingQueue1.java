package JavaAlgo.src.main.java.datastructure.blockingqueue;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue1<E> implements BlockingQueue<E>{

    private final E[] array;

    private int head;   //出队指针
    private int tail;   //入队指针
    private int size;   //数组当前成员数量

    private ReentrantLock lock = new ReentrantLock();   //锁对象

    private Condition headWaits = lock.newCondition();; //两个条件对象
    private Condition tailWaits = lock.newCondition();;


    public BlockingQueue1(int capacity) {
        array = (E[]) new Object[capacity];

    }

    private boolean isEmpty() {
        return size ==0;
    }

    private boolean isFull() {
        return size == array.length;
    }

    @Override
    public void offer(E e) throws InterruptedException {    //poll 等待队列非空
        //先加锁
        lock.lockInterruptibly();
        try {
            //防止虚假唤醒，用while,不用if
            while (isFull()) {
                //让当前线程到一个条件变量中去等待
                tailWaits.await();
            }
            array[tail] = e;
            if (++tail == array.length) {   //防止数组越界
                tail = 0;
            }
            size++;

            //唤醒等待队列非空的poll线程
            headWaits.signal();

        } finally {
            //解锁
            lock.unlock();
        }

    }

    //当等待时间超过timeout(毫秒) 返回false,否则返回true
    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {

        lock.lockInterruptibly();
        try {
            //将毫秒转换成纳秒
            long nanos = TimeUnit.MILLISECONDS.toNanos(timeout);
            while (isFull()) {
                if (nanos <= 0) {   //当nanos小于或等于0时，返回false
                    return false;
                }
                nanos = tailWaits.awaitNanos(nanos);  //等待多少纳秒  //返回值代表剩余时间
            }
            array[tail] = e;
            if (++tail == array.length) {   //防止数组越界
                tail = 0;
            }
            size++;
            //唤醒等待队列非空的poll线程
            headWaits.signal();
        } finally {
            //解锁
            lock.unlock();
        }
        return true;
    }

    @Override
    public E poll() throws InterruptedException {

        lock.lockInterruptibly();

        try {
            while (isEmpty()) {
                headWaits.await();
            }

            E e = array[head];
            array[head] = null; //help GC

            if (++head == array.length) {
                head = 0;
            }
            size--;
            //唤醒等待队列不满的offer线程
            tailWaits.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue1<String> queue = new BlockingQueue1<>(3);
        queue.offer("任务1");

        new Thread(()->{
            try {
                queue.offer("任务2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "offer").start();

        new Thread(()->{
            try {
                System.out.println(queue.poll());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "poll").start();
    }
}
