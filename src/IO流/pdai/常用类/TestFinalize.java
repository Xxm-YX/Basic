package IO流.pdai.常用类;

import java.io.File;
import java.io.FileNotFoundException;

public class TestFinalize {
    /**
     * 计数
     */
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        while(true) {
            new MyFileInputStream(new File("C:\\Users\\Lenovo\\Desktop\\a.txt"));
        }
    }
}