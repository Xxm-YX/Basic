package 设计模式.pdai.生成器模式.生成器模式;

import 设计模式.pdai.生成器模式.ExportDataModel;
import 设计模式.pdai.生成器模式.ExportFooterModel;
import 设计模式.pdai.生成器模式.ExportHeaderModel;

import java.util.Collection;
import java.util.Map;

/**
 * 实现导出数据到文本文件的的生成器对象
 */
public class TxtBuilder implements Builder {

    /**
     * 用来记录构建的文件的内容，相当于产品
     */
    private StringBuffer buffer = new StringBuffer();

    /**
     * 构建输出文件的Header部分
     *
     * @param ehm 文件头的内容
     */
    @Override
    public void buildHeader(ExportHeaderModel ehm) {
        buffer.append(ehm.getDepId()+","+ehm.getExportDate()+"\n");
    }

    /**
     * 构建输出文件的Body部分
     *
     * @param mapData 要输出的数据的内容
     */
    @Override
    public void buildBody(Map<String, Collection<ExportDataModel>> mapData) {
        for(String tblName : mapData.keySet()){
            //先拼接表名称
            buffer.append(tblName+"\n");
            //然后循环拼接具体数据
            for(ExportDataModel edm : mapData.get(tblName)){
                buffer.append(edm.getProductId()+","+edm.getPrice()+","+edm.getAmount()+"\n");
            }
        }
    }

    /**
     * 构建输出文件的Footer部分
     *
     * @param efm 文件尾的内容
     */
    @Override
    public void buildFooter(ExportFooterModel efm) {
        buffer.append(efm.getExportUser());
    }

    public StringBuffer getResult(){
        return buffer;
    }
}
