package 语雀学习.多线程与IO.从线程通信聊到阻塞队列;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author yixuan.zhu
 * @Description //TODO Condition版本
 * @Date 2021/7/1 14:10
 **/
public class ConditionQueue<T> {

    // 容器，用来装东西
    private final LinkedList<T> queue = new LinkedList<>();

    //显示锁（相对的，synchronized锁被成为隐式锁）
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition producerCondition = lock.newCondition();
    private final Condition consumerCondition = lock.newCondition();

    public void put(T resource) throws InterruptedException {
        lock.lock();
        try{
            while(queue.size() >= 1){
                //队列满了，不能再塞东西了，轮询等待消费者取出数据
                System.out.println("生产者：队列已满，无法插入...");
                //进行生产者阻塞
                producerCondition.await();
            }
            System.out.println("生产者：插入"+resource+"!!!");
            queue.addFirst(resource);
            //生产完毕，唤醒消费者
            consumerCondition.signal();
        }finally {
            lock.unlock();
        }
    }

    public void take() throws InterruptedException {
        lock.lock();
        try{
            while(queue.size() <= 0){
                //队列空了，不能再取东西，轮询等待生产者插入数据
                System.out.println("消费者：队列为空，无法取出");
                //消费者阻塞
                consumerCondition.await();
            }
            System.out.println("消费者：取出消息！！！");
            queue.removeLast();
            //消费完毕，唤醒生产者
            producerCondition.signal();
        }finally {
            lock.unlock();
        }
    }

}
