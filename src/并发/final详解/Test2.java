package 并发.final详解;

import java.util.Random;

public class Test2 {

    static Random r = new Random();
    final int k = r.nextInt(10);

    static final int k2 = r.nextInt(10);

    public static void main(String[] args) {
        Test2 t1 = new Test2();
        System.out.println("k="+t1.k+" k2="+t1.k2);
        Test2 t2 = new Test2();
        System.out.println("k="+t2.k+" k2="+t2.k2);
    }
}
