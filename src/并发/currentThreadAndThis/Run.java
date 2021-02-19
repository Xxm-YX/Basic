package 并发.currentThreadAndThis;

public class Run {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //初始化Thread对象，方便调用start();
        //此时myThread 作为参数传入Thread中，其实myThread 委托thread去执行
        Thread thread = new Thread(myThread);
        //初始化自定义线程名称
        thread.setName("C");
        //启动线程
        thread.start();
    }
}
