package 并发;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("111");
    }

    public static void main(String[] args) {
        MyRunnable instance = new MyRunnable();
        Thread thread = new Thread(instance);
        thread.start();
    }
}
