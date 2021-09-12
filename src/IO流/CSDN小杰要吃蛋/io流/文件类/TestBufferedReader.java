package IO流.CSDN小杰要吃蛋.io流.文件类;

import java.io.*;

/**
 * @author 78703
 * @version 1.0
 * @description: BufferedReader  处理流方式
 * @date 2021/5/7 13:44
 */
public class TestBufferedReader {

    public static void main(String[] args) throws IOException {
        int num = 0;
        //字符流接收使用的String数组
        String[] bufstring = new String[1024];
        //字符流，节点流打开文件类
        FileReader fr = new FileReader("D:\\test.txt");

        //处理流读取文件类
        BufferedReader br = new BufferedReader(fr);

        //临时接收数据使用的变量
        String line = null;

        //BufferReader.readLine():单行读取，读取为空返回null
        while ((line = br.readLine()) != null){
            bufstring[num++] = line;
        }
        br.close();
        for (int i = 0; i < num; i++) {
            System.out.println(bufstring[i]);
        }
    }
}
