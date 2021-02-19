package 并发.currentThreadAndThis;

public class MyThread extends Thread{

    public MyThread() {
        System.out.println("当前线程的名字1："+Thread.currentThread().getName());
        System.out.println("当前线程的名字2："+this.getName());
    }

    public void run(){
        System.out.println("当前线程的名字3："+Thread.currentThread().getName()+
                "   run=="+Thread.currentThread().isAlive());
        System.out.println("当前线程的名字4："+this.getName()+
                "   run=="+ this.isAlive());
    }
}
