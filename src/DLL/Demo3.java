package DLL;

import java.io.IOException;

/**
 * 演示调用exe程序
 */
public class Demo3 {


    public static void main(String[] args) throws IOException {
        // 设置启动参数
        String[] commands = {"cmd", "/c", "start", "\"\"", "D:\\WeChat\\WeChat.exe", "&&", "start", "\"\"", "D:\\WeChat\\WeChat.exe"};
        // 创建进程
        ProcessBuilder builder = new ProcessBuilder(commands);
        // 启动进程
        builder.start();
    }

}
