package 拷贝;

import org.junit.Test;

import java.util.Arrays;

public class SysDemo {

    /**
     * System.arraycopy()
     */
    @Test
    public void test1(){
        int[] arr = {1,2,3,4,5};

        int[] copied = new int[10];

        System.arraycopy(arr, 0 , copied, 1, 5);

        System.out.println(Arrays.toString(copied));


    }

    /**
     * Arrays.copyof()
     */
    @Test
    public void test2(){
        int[] arr = {1,2,3,4,5,0,0,0,0,0};

        int[] copied = Arrays.copyOf(arr,10);
        System.out.println(Arrays.toString(copied));
//        System.arraycopy(arr, 0 , copied, 1, 5);
        copied = Arrays.copyOf(arr,3);
        System.out.println(Arrays.toString(copied));
    }
}
