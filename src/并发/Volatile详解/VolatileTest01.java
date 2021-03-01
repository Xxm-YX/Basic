package 并发.Volatile详解;

public class VolatileTest01 {

    volatile int i;

    public void addI(){
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        final VolatileTest01 test01 = new VolatileTest01();
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    test01.addI();
                }
            }).start();
        }
        Thread.sleep(10000);//等10秒，保证上面程序执行完成
        System.out.println(test01.i);
    }
}
