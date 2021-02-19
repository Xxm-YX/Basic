package 并发;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {

    @Test
    public void Test1(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable());
        }
        executorService.shutdown();
    }

    @Test
    public void Test2(){
        Thread thread = new Thread(new MyRunnable());
        thread.setDaemon(true);
    }
}
