package homework.plane;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        new Plane();
        int xx = 0;   //判断标记，如果出现error,即以后不管输入什么,都是Error
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("输入id:");
            int id = sc.nextInt();
            String data = Plane.print(id);
            if (data == "error") {
                xx = 1;
                System.out.println("Error: " + id);

            } else if (data == "noId") {
                if (xx == 0) {
                    System.out.println("Cannot find " + id);
                } else {
                    System.out.println("Error: " + id);
                }

            } else {
                if (xx == 0) {
                    System.out.println("panle1 " + id + data);
                } else {
                    System.out.println("Error: " + id);
                }

            }

        }
    }
}