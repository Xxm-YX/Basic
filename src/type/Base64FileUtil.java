package type;




import java.io.*;
import java.util.Base64;


public class Base64FileUtil {


    private static String targetFilePath = "E:\\base2Img\\target\\test.txt";


    public static void main(String[] args) throws Exception {
        String fileStr = getFileStr("E:\\base2Img\\big test.txt");
        System.out.println("fileStr ===" + fileStr);
        System.out.println(generateFile(fileStr, targetFilePath));
        System.out.println("end");
    }


    /**
     * 文件转化成base64字符串
     * 将文件转化为字节数组字符串，并对其进行Base64编码处理
     */
    public static String getFileStr(String filePath) {
        InputStream in = null;
        byte[] data = null;
        // 读取文件字节数组
        try {
            in = new FileInputStream(filePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 对字节数组Base64编码
        Base64.Encoder encoder =  Base64.getEncoder();
        // 返回 Base64 编码过的字节数组字符串
        return encoder.encodeToString(data);
    }


    /**
     * base64字符串转化成文件，可以是JPEG、PNG、TXT和AVI等等
     *
     * @param base64FileStr
     * @param filePath
     * @return
     * @throws Exception
     */
    public static boolean generateFile(String base64FileStr, String filePath) throws Exception {
        // 数据为空
        if (base64FileStr == null) {
            System.out.println(" 不行，oops！ ");
            return false;
        }
        Base64.Decoder decoder = Base64.getDecoder();


        // Base64解码,对字节数组字符串进行Base64解码并生成文件
        byte[] byt = decoder.decode(base64FileStr);
        for (int i = 0, len = byt.length; i < len; ++i) {
            // 调整异常数据
            if (byt[i] < 0) {
                byt[i] += 256;
            }
        }
        OutputStream out = null;
        InputStream input = new ByteArrayInputStream(byt);
        try {
            // 生成指定格式的文件
            out = new FileOutputStream(filePath);
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = input.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
        }
        return true;
    }

}