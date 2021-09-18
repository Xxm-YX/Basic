package IO流.pdai.常用类;

import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;

/**
 * @author 78703
 * @version 1.0
 * @description:
 * @date 2021/5/10 23:03
 */
public class CommonlyClass {

    /**
     * @description: 递归列出所有文件
     * @author zyx
     * @date 2021/5/10 23:04
     * @version 1.0
     */
    public static void listAllFiles(File dir){
        if(dir == null || !dir.exists()){
            return;
        }

        if(dir.isFile()){
            System.out.println(dir.getName());
            return;
        }

        for(File file : dir.listFiles()){
            listAllFiles(file);
        }
    }

    /**
     * @description: 复制文件
     * @author zyx
     * @date 2021/5/10 23:07
     * @version 1.0
     */
    public static void copyFile(String src,String dist) throws IOException {

        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dist);
        byte[] buffer = new byte[20 * 1024];

        // read() 最多读取buffer.length个字符
        // 返回的是实际读取的个数
        // 返回 -1 的时候表示读到 eof，即文件尾
        while (in.read(buffer, 0, buffer.length) != -1) {
            out.write(buffer);
        }

        in.close();
        out.close();
    }

    /**
     * @description: 实现逐行输出文件内容
     * @author zyx
     * @date 2021/5/10 23:11
     * @version 1.0
     */
    public static void readFileContent(String filePath) throws IOException {

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;

        while((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

        //装饰者模式使得BufferedReader 组合了一个Reader对象
        //在调用 BufferedReader 的 close（） 方法时会去调用Reader的 close()方法

        bufferedReader.close();
    }

    /**
     * @description: 序列化
     * @author zyx
     * @date 2021/5/10 23:17
     * @version 1.0
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        A a1 = new A(123,"abc");
        String objectFile = "D://file/a1.txt";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
        objectOutputStream.writeObject(a1);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(objectFile));
        A a2 = (A) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(a2);
    }

    private static class A implements Serializable{
        private int x;

        private String y;

        A(int x, String y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x = " + x + "  " + "y = " + y;
        }
    }

    /**
     * @description:  URL中读取字节流数据
     * @author zyx
     * @date 2021/5/10 23:25
     * @version 1.0
     */
    @Test
    public void Test() throws IOException {
        URL url = new URL("http://www.baidu.com");

        //字节流
        InputStream is = url.openStream();

        //字符流
        InputStreamReader isr = new InputStreamReader(is,"utf-8");

        //提供缓存功能
        BufferedReader br = new BufferedReader(isr);

        String line ;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}

