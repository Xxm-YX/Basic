package homework.plane;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

class Plane {
    // 初始化，记录数据 输入数据，记录到properties文件中,给予一个标记表示输入完毕。
    public Plane() throws Exception {
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        // 输入exit结束输入
        while (true) {
            System.out.print("plane1:");
            String line = sc.nextLine();
            if (line.equals("exit".trim())) {
                break;
            }
            list.add(line);
        }
        OutputStream output = new FileOutputStream("dababase.properties");
        Properties props = new Properties();
        for (int i = 0; i < list.size(); i++) {
            props.setProperty(i + "", list.get(i));

        }

        props.store(output, null);

    }

    // 操作数据
    public static String print(int id) throws Exception {
        Properties props = new Properties();
        InputStream input = new FileInputStream("dababase.properties");
        props.load(input);
        String data = null;
        try {
            data = props.getProperty(id + "");
            String[] nums = data.split("\\s+");
            if (nums.length == 3) {
                if (id == 0) {
                    return " " + nums[0] + " " + nums[1] + " " + nums[2];
                } else {
                    return "error";
                }
            } else {
                String[] array = new String[3];
                array[0] = (Integer.parseInt(nums[0]) + Integer
                        .parseInt(nums[3])) + "";
                array[1] = (Integer.parseInt(nums[1]) + Integer
                        .parseInt(nums[4])) + "";
                array[2] = (Integer.parseInt(nums[2]) + Integer
                        .parseInt(nums[5])) + "";
                return " " + array[0] + " " + array[1] + " " + array[2];
            }
        } catch (Exception e) {
            return "noId";
        }
    }
}


