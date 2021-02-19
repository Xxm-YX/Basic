package 并发;

public class MyThread extends Thread{
    public void run(){
        System.out.println("aaaa");
    }

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();
    }
}
