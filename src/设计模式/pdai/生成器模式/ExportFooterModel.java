package 设计模式.pdai.生成器模式;

/**
 * 描述输出到文件尾的内容的对象
 */
public class ExportFooterModel {
    /**
     * 输出人
     */
    private String exportUser;
    public String getExportUser() {
        return exportUser;
    }
    public void setExportUser(String exportUser) {
        this.exportUser = exportUser;
    }
}
