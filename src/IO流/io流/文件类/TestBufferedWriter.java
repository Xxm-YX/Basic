package IO流.io流.文件类;

import java.io.*;

/**
 * @author 78703
 * @version 1.0
 * @description: 增加缓冲功能，避免频繁读写硬盘
 * @date 2021/5/7 14:15
 */
public class TestBufferedWriter  {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\test.txt");

        //new FileWriter(file);  这里没有加true 代表覆盖文件

        Writer writer = new FileWriter(file);

        BufferedWriter bw = new BufferedWriter(writer);

        bw.write("\n小心");

        bw.close();
        writer.close();
    }
}
