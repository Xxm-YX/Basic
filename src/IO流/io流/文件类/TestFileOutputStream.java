package IO流.io流.文件类;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 78703
 * @version 1.0
 * @description: 用的节点流
 * @date 2021/5/7 14:32
 */
public class TestFileOutputStream {

    public static void main(String[] args) throws IOException {
        //创建字节输入流，节点流方式读取文件
        FileInputStream fis = new FileInputStream("D:\\43vgyn.jpg");

        //创建字节输入流，节点流方式输出文件
        FileOutputStream fos = new FileOutputStream("D:\\copy.jpg");
        //根据文件大小做一个字节数组
        byte[] arr = new byte[fis.available()];

        fis.read(arr);

        //将数组中的所有字节一次写到文件上
        fos.write(arr);

        fis.close();
        fos.close();



    }
}
