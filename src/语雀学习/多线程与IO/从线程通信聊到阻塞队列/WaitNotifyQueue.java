package 语雀学习.多线程与IO.从线程通信聊到阻塞队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author yixuan.zhu
 * @Description //TODO wati/notify版本
 * @Date 2021/7/1 13:59
 **/
public class WaitNotifyQueue<T> {

    // 容器，用来装东西
    private final Deque<T> queue = new LinkedList<>();

    public synchronized void put(T resource) throws InterruptedException {
        while(queue.size() >= 1){
            // 队列满了，不能再塞东西了，轮询等待消费者取出数据
            System.out.println("生产者：队列已满，无法插入...");
            this.wait();
        }
        System.out.println("生产者：插入" + resource + "!!!");
        queue.addFirst(resource);
        this.notifyAll();
    }

    public synchronized void take() throws InterruptedException {
        while (queue.size() <= 0) {
            // 队列空了，不能再取东西，轮询等待生产者插入数据
            System.out.println("消费者：队列为空，无法取出...");
            this.wait();
        }
        System.out.println("消费者：取出消息!!!");
        queue.removeLast();
        this.notifyAll();
    }
}
