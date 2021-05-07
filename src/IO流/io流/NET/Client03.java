package IO流.io流.NET;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 78703
 * @version 1.0
 * @description:
 * @date 2021/5/7 14:47
 */
public class Client03 {

    public static void main(String[] args) throws IOException {
        //创建套接字对象socket并封装ip与port
        Socket socket = new Socket("127.0.0.1",8000);

        //基于字节流
        OutputStream outputStream = socket.getOutputStream();

        System.out.println("TCP连接成功 \n 请输入：");
        String str = new Scanner(System.in).nextLine();
        byte[] car = str.getBytes();
        outputStream.write(car);
        System.out.println("TCP协议的Socket发送成功");

        outputStream.flush();

        socket.close();
    }
}
