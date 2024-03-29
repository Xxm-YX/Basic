package 设计模式.pdai.适配器模式.双向适配器;

import 设计模式.pdai.适配器模式.不用模式.LogDbOperateApi;
import 设计模式.pdai.适配器模式.不用模式.LogModel;

import java.util.List;

/**
 * DB存储日志的实现，为了简单，这里就不去真的实现和数据库交互了，示意一下
 */
public class LogDbOperate implements LogDbOperateApi {
    public void createLog(LogModel lm) {
        System.out.println("now in LogDbOperate createLog,lm="+lm);
    }
    public List<LogModel> getAllLog() {
        System.out.println("now in LogDbOperate getAllLog");
        return null;
    }
    public void removeLog(LogModel lm) {
        System.out.println("now in LogDbOperate removeLog,lm="+lm);
    }
    public void updateLog(LogModel lm) {
        System.out.println("now in LogDbOperate updateLog,lm="+lm);
    }
}