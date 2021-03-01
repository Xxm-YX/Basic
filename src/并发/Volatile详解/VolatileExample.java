package 并发.Volatile详解;

/**
 * 有序性实现
 */
public class VolatileExample {

    int a = 0;
    volatile boolean flag = false;

    public void writer(){
        a = 1;      //1 线程A修改共享变量
        flag = true;//2 线程A写volatile变量
    }

    public void reader(){
        if(flag){   //3 线程B读同一个volatile变量
            int i = a;  //4 线程B 读共享变量
        }
    }

}
