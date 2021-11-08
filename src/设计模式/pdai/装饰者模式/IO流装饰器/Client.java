package 设计模式.pdai.装饰者模式.IO流装饰器;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Client {
    public static void main(String[] args) throws Exception {
        //流式输出文件
        DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(
                //这是我们加的装饰器
                new EncryptOutputStream(new FileOutputStream("MyEncrypt.txt"))));
        //然后就可以输出内容了
        dout.write("abcdxyz".getBytes());
        dout.close();
    }
}

