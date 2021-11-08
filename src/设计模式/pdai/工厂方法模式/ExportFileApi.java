package 设计模式.pdai.工厂方法模式;

/**
 * 导出的文件对象的接口    抽象
 */
public interface ExportFileApi {
    /**
     * 导出内容成为文件
     * @param data 示意：需要保存的数据
     * @return 是否导出成功
     */
    public boolean export(String data);
}