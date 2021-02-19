package 并发;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorShutDown {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //把线程 扔进去
        executorService.execute(() -> {
            try{
                Thread.sleep(2000);
                System.out.println("Thread run");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
/*
        //中断线程  submit一样，把线程扔进去
        Future<?> future = executorService.submit(() ->{
           //..
        });
        future.cancel(true);*/
        executorService.shutdownNow();
//        executorService.shutdown();
        System.out.println("Main run");
    }
}
