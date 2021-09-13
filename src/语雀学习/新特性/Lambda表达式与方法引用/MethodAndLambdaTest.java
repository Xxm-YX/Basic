package 语雀学习.新特性.Lambda表达式与方法引用;

/**
 * MyPredict是模拟Predict
 * MyInteger是模拟Integer
 * <p>
 * 本次测试的目的旨在说明：Lambda毕竟是手写的，自由度和细粒度要高于方法引用。
 *
 * @author sunting
 */
public class MethodAndLambdaTest {

    public static void main(String[] args) {
        //1.匿名对象
        MyPredict myPredict1 = new MyPredict() {
            @Override
            public boolean test(int a, int b) {
                return a - b > 0;
            }
        };
        boolean result1 = myPredict1.test(1,2);


        //2.从匿名对象过度到Lambda表达式
        MyPredict myPredict2 = (a,b) -> a - b > 0;
        myPredict2.test(1,2);


        //3.MyInteger #compare()的方法体和上面的lambda表达式逻辑相同，可以直接引用
        MyPredict myPredict3 = MyInteger::compare;
        myPredict3.test(1,2);

        // 4.Lambda说，你想模仿我？想得美！老子要DIY一下比较规则（a减b 变成了 b减a）
        MyPredict myPredict4 = (a,b) -> b - a > 0;
        myPredict4.test(1,2);

        // MyInteger::anotherCompare的逻辑和上面的Lambda才是匹配的
        MyPredict myPredict5 = MyInteger::anotherCompare;
        myPredict5.test(1, 2); // true
    }
}

interface MyPredict{
    boolean test(int a,int b);
}

class MyInteger{
    public static boolean compare(int a,int b){
        return a - b > 0;
    }

    public static boolean anotherCompare(int a, int b) {
        return b - a > 0;
    }
}
