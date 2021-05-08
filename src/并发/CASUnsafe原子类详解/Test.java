package 并发.CASUnsafe原子类详解;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    //不使用CAS，在高并发下，多线程同时修改一个变量的值，我们需要
    //synchronized加锁(可能有人说Lock，Lock底层的AQS
    //也是基于CAS进行获取锁的

    private int b = 0;
    public synchronized int add1(){
        return b++;
    }

    //java中提供的AtomicInteger原子类（底层基于CAS进行更新数据）
    //不需要加锁就在多线程并发场景下实现数据的一致性

    private AtomicInteger i = new AtomicInteger(0);
    public int add2(){
        return i.addAndGet(1);
    }

    @org.junit.Test
    public void t(){
        System.out.println(add2());
    }
}
