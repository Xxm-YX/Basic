package 并发;

public class InterrupExample {
    private static class MyThread2 extends Thread{
        @Override
        public void run() {
            while(!interrupted()){
                System.out.println("aaa");
            }
            System.out.println("Thread end");
        }
    }

    public static void main(String[] args) {
        Thread thread2 = new MyThread2();
        thread2.start();
        thread2.interrupt();
    }
}
