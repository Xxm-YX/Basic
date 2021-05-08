package 并发.Volatile详解;

/**
 * 实现可见性
 * 每个线程都拥有一个自己的高速缓存区——线程工作内存
 */
public class VolatileTest {
    volatile int a = 1;
    volatile int b = 2;

    public void change(){
        a = 3;
        b = a;
    }

    public void print(){
        System.out.println("b="+b + ";a="+a);
    }

    public static void main(String[] args) {
        while(true){
            final VolatileTest test = new VolatileTest();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    test.change();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.print();
                }
            }).start();
        }
    }
}
