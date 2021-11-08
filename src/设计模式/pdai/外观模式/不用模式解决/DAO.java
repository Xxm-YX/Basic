package 设计模式.pdai.外观模式.不用模式解决;

/**
 * 示意生成数据层的模块
 */
public class DAO {
    public void generate(){
        ConfigModel cm = ConfigManager.getInstance().getConfigData();
        if(cm.isNeedGenDAO()){
            System.out.println("正在生成数据层代码文件");
        }
    }
}