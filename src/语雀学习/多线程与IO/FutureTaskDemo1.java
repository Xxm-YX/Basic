package 语雀学习.多线程与IO;


import java.util.concurrent.*;

/**
 * @Author yixuan.zhu
 * @Description //TODO isDone  配合 get方法
 * @Date 2021/7/1 11:51
 **/
public class FutureTaskDemo1 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //1.主线程开启异步线程处理耗时任务，同时返回FutureTask
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> futureTask = executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "======>正在执行");
            Thread.sleep(3 * 1000L);
            return "success";
        });


        //2.主线程也不闲着，继续往下执行自己的任务
        Thread.sleep(1000L);

        //3.尝试获取
        if(futureTask.isDone()){
            System.out.println("异步线程结束了，获取结果："+futureTask.get());
        }else {
            System.out.println("异步线程尚未结束，稍后再试");
        }

        //4.继续干活
        Thread.sleep(1000L);
        Thread.sleep(1000L);

        if(futureTask.isDone()){
            System.out.println("异步线程结束了，获取结果："+futureTask.get());
        }else {
            System.out.println("异步线程尚未结束，稍后再试");
        }
    }


}
