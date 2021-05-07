package IO流.io流.文件类;

import java.io.*;

/**
 * @author 78703
 * @version 1.0
 * @description:
 * @date 2021/5/7 14:37
 */
public class TestBufferedOutputStream {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\copy.jpg");

        //创建缓冲区对fis装饰
        //避免每次和硬盘打交道，提高数据访问的效率。
        BufferedInputStream bis = new BufferedInputStream(fis);

        //创建输出流对象。关联copy
        FileOutputStream fos = new FileOutputStream("D:\\copy2.jpg");

        //创建缓冲区对fos装饰
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int i;
        while((i = bis.read()) != -1){
            //i为读取长度
            bos.write(i);
        }

        bis.close();
        bos.close();

    }
}
