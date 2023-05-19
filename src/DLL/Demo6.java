package DLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 演示调用exe程序
 */
public class Demo6 {


    public static void main(String[] args) {
        String processName = "WeChat.exe"; // 要查找的进程名

        System.out.println("cmd /c wmic process where \"name='" + processName + "'\" get processid");
        try {
            Process process = Runtime.getRuntime().exec("cmd /c wmic process where \"name='" + processName + "'\" get processid"); // 执行命令行
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "GBK"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty() && !line.equalsIgnoreCase("ProcessId")) {
                    System.out.println(processName + " 的 PID 是 " + line);
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
