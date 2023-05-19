package DLL;

import java.io.IOException;
import java.util.Scanner;

/**
 * 演示调用exe程序
 */
public class Demo4 {

    public static void main(String[] args) {

        while (true) {
            // 循环启动多个微信客户端

            Scanner scanner = new Scanner(System.in);

            int i = scanner.nextInt();
            if (i == 1) {
                System.out.println("正在启动微信客户端 " + (i + 1));
                String cmd = "cmd /c start \"\" \"D:\\WeChat\\WeChat.exe\"";
                try {
                    Runtime.getRuntime().exec(cmd);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }



        }


    }

}
