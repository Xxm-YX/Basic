package 语雀学习.多线程与IO.从线程通信聊到阻塞队列;

import java.util.LinkedList;

/**
 * @Author yixuan.zhu
 * @Description //TODO 山寨阻塞队列
 * @Date 2021/7/1 14:25
 **/
public class BlockingQueue<T> {

    //模拟队列
    private final LinkedList<T> queue = new LinkedList<>();

    private int MAX_SIZE = 1;
    private int remainCount = 0;

    public BlockingQueue(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("size最小为1");
        }
        this.MAX_SIZE = capacity;
    }

    public synchronized void put(T resource) throws InterruptedException {
        while(queue.size() >= MAX_SIZE){
            //队列满了，不能再塞了，阻塞生产者
            System.out.println("插入阻塞");
            this.wait();
        }
        queue.addFirst(resource);
        remainCount++;
        printMsg(resource,"被插入");
        this.notifyAll();
    }

    public synchronized T take() throws InterruptedException {
        while (queue.size() <= 0) {
            // 队列空了，不能再取东西了，阻塞消费者
            System.out.println("取出阻塞...");
            this.wait();
        }
        T resource = queue.removeLast();
        remainCount--;
        printMsg(resource, "被取出");
        this.notifyAll();
        return resource;
    }

    private void printMsg(T resource, String operation) throws InterruptedException {
        System.out.println(resource + operation);
        System.out.println("队列容量：" + remainCount);
    }
}
