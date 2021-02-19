package 泛型;

import org.junit.Test;

public class GenericsDemo30 {

    @Test
    public void Test(){
        Integer i[] = fun1(1,2,3,4,5,6);
        fun2(i);
    }

    private static <T> T[] fun1(T...arg) {
        return arg;
    }

    public static <T> void fun2(T param[]){
        System.out.println("接收泛型数组：");
        for (T t : param) {
            System.out.println(t + "、");
        }
    }

    /*public GenericsDemo30(Class<T> type, int size){
        array = (T[]) Array.ne
    }*/
}
