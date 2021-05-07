package IO流.io流.文件类;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 78703
 * @version 1.0
 * @description:
 * @date 2021/5/7 14:11
 */
public class TestFileWriter {

    public static void main(String[] args) throws IOException {
        //File 是操作文件类
        File file = new File("D:\\test.txt");
        //字符流、节点流写出文件类
        //new FileWriter（file，true） 这个true代表追加。不写就代表覆盖文件
        FileWriter out = new FileWriter(file,true);

        String str = "\nholler";

        out.write(str);
        out.close();
    }
}
