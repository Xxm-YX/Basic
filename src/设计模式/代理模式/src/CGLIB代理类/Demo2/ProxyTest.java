package 设计模式.代理模式.src.CGLIB代理类.Demo2;

import org.junit.Test;

public class ProxyTest {

    @Test
    public void testCglibProxy(){
        //创建一个Programmer对象
        Programmer programmerA = new Programmer();
        programmerA.setName("Frank");

        programmerA.code();
        System.out.println("----------------");
        System.out.println();
        System.out.println("代理对象");
        //创建代理对象
        Programmer programmerProxyA = new ProgrammerProxy().createProxy(programmerA);
        programmerProxyA.code();

        System.out.println("-----------------");
        //修改代理对象
        System.out.println("修改代理对象");
        programmerProxyA.setName("Wang");
        programmerProxyA.code();

        System.out.println("------------------");

        System.out.println();
        System.out.println("查看委托对象");
        programmerA.code();

        System.out.println("-----------------");
        //修改委托类对象
        programmerA.setName("Song");
        programmerProxyA.code();
    }
}
