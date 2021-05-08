package 并发.CASUnsafe原子类详解;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Demo5 {

    public static void main(String[] args) {
        AtomicIntegerArray array = new AtomicIntegerArray(new int[]{0,0});
        System.out.println(array);
        System.out.println(array.getAndAdd(1,2));
        System.out.println(array);
    }
}
