package 并发;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUnsafeExample {

    private int cnt = 0;

    public void add(){
        cnt++;
    }

    public int get(){
        return cnt;
    }

    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 100000;
        ThreadUnsafeExample example = new ThreadUnsafeExample();
        //计数器
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() ->{
                example.add();
                countDownLatch.countDown();
            });
        }
        //await ——condition
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(example.get());
    }
}
