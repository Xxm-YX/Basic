package type;

import org.junit.Test;

import java.util.Base64;

public class btye2string {

    @Test
    public void Test1(){
        String string = "hello world";
        byte[] bytes = string.getBytes();

        for (byte aByte : bytes) {
            System.out.print(aByte);
        }

        String s = new String(bytes);

        System.out.println("decoded string : "+s);
    }

    @Test
    public void Test2(){
        byte[] bytes = "hello world".getBytes();

        //将unicode编码的字符串编码成二进制数据
        //再讲二进制数据码编写成Ascii
        String encoded = Base64.getEncoder().encodeToString(bytes);

        //将二进制数据解码成unicode编码
        byte[] decoded = Base64.getDecoder().decode(encoded);

        System.out.println(encoded);
        for (byte b : decoded) {
            System.out.print(b);
        }
        System.out.println();
        System.out.println(new String(decoded));
    }

    @Test
    public void Test3(){
        String string = "hello world";
        byte[] bytes = string.getBytes();
        String s = new String(bytes);
        Long b = Long.parseLong(s);
        System.out.println(b);
    }

    @Test
    public void test4(){
        double a = 3;
        double b = 0.3;
        System.out.println( a * 0.1);
        System.out.println(b == a * 0.1);
    }
}
