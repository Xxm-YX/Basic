package 消费者模式.waitNotify;

import java.sql.SQLOutput;

public class Test {
    private static Integer count = 0;
    private static final Integer Total = 10;
    private static String flag = "agree";

    public static void main(String[] args) {
        Test test = new Test();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
    }

    public class Producer implements Runnable{
        @Override
        public void run() {
            for (int i = 0;i < 5; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (flag) {
                    while (count.equals(Total)) {
                        try {
                            flag.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName()+"生产者共有" + count);
                    flag.notifyAll();
                }
            }
        }
    }
    public class Consumer implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 5; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (flag){
                    while(count == 0){
                        try {
                            flag.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    flag.notifyAll();
                }
            }
        }
    }
}