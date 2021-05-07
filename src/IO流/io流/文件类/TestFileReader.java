package IO流.io流.文件类;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 78703
 * @version 1.0
 * @description:FileReader类 （字符输入流）
 * @date 2021/5/7 12:13
 */

public class TestFileReader {

    public static void main(String[] args) throws IOException {
        int num = 0;
        //字符流接受使用的char数组
        char[] buf = new char[1024];

        //字符流，节点流打开文件类
        FileReader fr = new FileReader("D:\\test.txt");//文件必须存在
        //FileReader.read()：取出字符存到buf数组中,如果读取为-1代表为空即结束读取。
        //FileReader.read()：读取的是一个字符，但是java虚拟机会自动将char类型数据转换为int数据，
        //如果你读取的是字符A，java虚拟机会自动将其转换成97，如果你想看到字符可以在返回的字符数前加（char）强制转换如

        while((num=fr.read(buf))!= -1){ }

        for (int i = 0; i < buf.length; i++) {
            System.out.print(buf[i]);
        }
    }
}
