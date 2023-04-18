package 并发.aqs;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Snailclimb
 * @date 2018年9月30日
 * @Description: 需要一次性拿一个许可的情况
 */
public class SemaphoreExample1 {

    // 请求数量
    private static final int THREAD_COUNT = 550;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(300);

        final Semaphore semaphore = new Semaphore(20);

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadNum = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        test(threadNum);
                        semaphore.release();
                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
                        e.printStackTrace();
                    }
                }
            });

        }
    }

    public static void test(int threadnum) throws InterruptedException {
        Thread.sleep(1000);// 模拟请求的耗时操作
        System.out.println("threadnum:" + threadnum);
        Thread.sleep(1000);// 模拟请求的耗时操作
    }
}
