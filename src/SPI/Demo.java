package SPI;

import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;

public class Demo {


    // 使用线程上下文类加载器加载资源
    public static void main(String[] args) throws Exception{
        // Array.class的完整路径
        String name = "java/sql/Array.class";
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(name);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url.toString());
        }

    }

}
