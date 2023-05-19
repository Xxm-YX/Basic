package DLL;

import java.io.IOException;
import java.util.Scanner;

/**
 * 演示调用exe程序
 */
public class Demo5 {

    public static void main(String[] args) throws IOException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            if (i == 1) {
                System.out.println("正在启动微信客户端 " + i);
                // 创建新的 ProcessBuilder 对象
                String[] commands = {"cmd", "/c", "start", "\"\"", "D:\\WeChat\\WeChat.exe"};
                ProcessBuilder builder = new ProcessBuilder(commands);
                builder.start();
            }
        }
    }

}
