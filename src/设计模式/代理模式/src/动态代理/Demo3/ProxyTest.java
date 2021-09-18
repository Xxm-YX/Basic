package 设计模式.代理模式.src.动态代理.Demo3;

import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        Student s = new Student();
        Person proxy = (Person) Proxy.newProxyInstance(
                s.getClass().getClassLoader(),
                new Class[]{Person.class},
                new MyInvocation(s));

        String b = proxy.say("i a student");

        System.out.println(b);

    }
}
