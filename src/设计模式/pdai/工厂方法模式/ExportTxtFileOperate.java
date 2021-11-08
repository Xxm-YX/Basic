package 设计模式.pdai.工厂方法模式;

/**
 * 底层组件
 */
public class ExportTxtFileOperate extends ExportOperate {
    @Override
    protected ExportFileApi factoryMethod() {
        //创建导出成文本文件格式的对象
        return new ExportTxtFile();
    }
}
