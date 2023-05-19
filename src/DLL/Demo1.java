package DLL;

/**
 * 演示调用exe程序
 */
public class Demo1 {

    public static void main(String[] args) {
        try {
            // 启动记事本程序
            Process p = Runtime.getRuntime().exec("D:\\WeChat\\WeChat.exe");
            // 等待程序执行结束并输出退出码
            int exitCode = p.waitFor();
            System.out.println("程序执行结束，退出码：" + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
