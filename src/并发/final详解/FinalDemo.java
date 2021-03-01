package 并发.final详解;

import java.io.File;

public class FinalDemo {

    private int a;  //普通域
    private final int b;    //final域
    private static FinalDemo finalDemo;

    public FinalDemo() {
        this.a = 1;//   写普通域
        this.b = 1;//   写final域
    }

    public static void writer(){
        finalDemo = new FinalDemo();
    }

    public static void reader(){
            FinalDemo demo = finalDemo;//3.读对象应用
        int a = demo.a;                 //4.读普通域
        int b = demo.b;                 //5.读final域
        System.out.println(demo);
        System.out.println(a);
        System.out.println(b);
    }


    public static void main(String[] args) {
        FinalDemo finalDemo = new FinalDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                finalDemo.writer();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                finalDemo.reader();
            }
        }).start();
    }
}
