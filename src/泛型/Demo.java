package 泛型;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class Demo {

    //上限======允许 自己 或者 自己的子类进入
    class Info<T extends  Number>{
        private T var;//定义的泛型变量
        public void setVar(T var){
            this.var = var;
        }
        public T getVar(){
            return this.var;
        }
        public String toString(){
            return this.var.toString();
        }
    }

    @Test
    public void Test(){
        Info<Integer> i1 = new Info<Integer>();//声明Integer的泛型对象
        i1.setVar(10);
        System.out.println(i1.getVar());
    }

    //下限======允许自己 或者 父类进去
    class Info1<T>{
        private T var;
        public void setVar(T var){
            this.var = var;
        }
        public T getVar(){
            return this.var;
        }
        public String toString(){
            return this.var.toString();
        }
    }

    @Test
    public void Test2(){
        Info1<String> i1 = new Info1<String>();
        Info1<Object> i2 = new Info1<Object>();
        i1.setVar("hello");
        i2.setVar(new Object());
        fun(i1);
        fun(i2);
    }

    public void fun(Info1<? super String> temp){
        System.out.println(temp + ",");
    }

    //=========================================
    //加深印象
    private <E extends  Comparable<? super E>> E max(List<? extends E> e1){
        if(e1 == null){
            return null;
        }
        //迭代器返回的元素 属于E的某个子类型
        Iterator<? extends E>iterator = e1.iterator();
        E result = iterator.next();
        while(iterator.hasNext()){
            E next = iterator.next();
            if(next.compareTo(result) > 0){
                result = next;
            }
        }
        return result;
    }
}
