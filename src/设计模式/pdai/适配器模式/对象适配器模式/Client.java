package 设计模式.pdai.适配器模式.对象适配器模式;

import 设计模式.pdai.适配器模式.不用模式.LogDbOperateApi;
import 设计模式.pdai.适配器模式.不用模式.LogFileOperate;
import 设计模式.pdai.适配器模式.不用模式.LogFileOperateApi;
import 设计模式.pdai.适配器模式.不用模式.LogModel;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        //准备日志内容，也就是测试的数据
        LogModel lm1 = new LogModel();
        lm1.setLogId("001");
        lm1.setOperateUser("admin");
        lm1.setOperateTime("2010-03-0210:08:18");
        lm1.setLogContent("这是一个测试");
        List<LogModel> list = new ArrayList<LogModel>();
        list.add(lm1);
        //创建操作日志文件的对象
        LogFileOperateApi logFileApi = new LogFileOperate("");

        //创建新版的操作日志的接口对象
        LogDbOperateApi api = new Adapter(logFileApi);

        //保存日志文件
        api.createLog(lm1);
        //读取日志文件的内容
        List<LogModel> allLog = api.getAllLog();
        System.out.println("allLog="+allLog);
    }
}
