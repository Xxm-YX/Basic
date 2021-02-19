package 并发.SynchronizedDemo;

public class SynchronizedDemo2 implements Runnable{
    static SynchronizedDemo2 synchronizedDemo2 = new SynchronizedDemo2();

    Object object = new Object();
    public void method1() throws InterruptedException {
        synchronized (object){
            //***
            System.out.println("object被锁住了");
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(3000);


        }
    }

    @Override
    public void run() {

        try {
            method1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("锁释放了");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(synchronizedDemo2);
        Thread t2 = new Thread(synchronizedDemo2);
        t1.start();
        t2.start();
    }
}
