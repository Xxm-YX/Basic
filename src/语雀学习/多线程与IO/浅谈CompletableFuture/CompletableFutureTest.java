package 语雀学习.多线程与IO.浅谈CompletableFuture;

import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * @author Lenovo
 */
public class CompletableFutureTest {

    private static final ExecutorService executor = Executors.newFixedThreadPool(5);

    /**
     * 轮询异步结果并获取
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void testFutureAsk() throws ExecutionException, InterruptedException {

        // 任务1
        Future<String> runnableFuture = executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Runnable异步线程开始...");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("Runnable异步线程结束...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "fakeRunnableResult");

        // 任务2
        Future<String> callableFuture = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Callable异步线程开始...");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Callable异步线程结束...");
                return "callableResult";
            }
        });

        boolean runnableDone = false;
        boolean callableDone = false;

        // 不断轮询，直到所有任务结束
        while (true) {
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("轮询异步结果...");
            if (runnableFuture.isDone()) {
                System.out.println("Runnable执行结果:" + runnableFuture.get());
                runnableDone = true;
            }
            if (callableFuture.isDone()) {
                System.out.println("Callable执行结果:" + callableFuture.get());
                callableDone = true;
            }
            if (runnableDone && callableDone) {
                break;
            }
        }

        System.out.println("任务全部结束");
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testFutureAsk();
    }

    public void testCallBack() throws ExecutionException, InterruptedException {
        //提交一个任务，返回CompletableFuture
        CompletableFuture<Object> completableFuture = CompletableFuture.supplyAsync(new Supplier<Object>() {
            @Override
            public Object get() {
                System.out.println("=============>异步线程开始...");
                System.out.println("=============>异步线程为：" + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("=============>异步线程结束...");
                return "supplierResult";
            }
        });

        // 阻塞获取结果
        System.out.println("异步结果是:" + completableFuture.get());
        System.out.println("main结束");
    }
}
