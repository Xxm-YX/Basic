package 设计模式.pdai.生成器模式.生成器模式;

import 设计模式.pdai.生成器模式.ExportDataModel;
import 设计模式.pdai.生成器模式.ExportFooterModel;
import 设计模式.pdai.生成器模式.ExportHeaderModel;

import java.util.Collection;
import java.util.Map;

/**
 * 实现导出数据到XML文件的的生成器对象
 */
public class XmlBuilder implements Builder {

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
        buffer.append("<?xml version='1.0' encoding='gb2312'?>\n");
        buffer.append("<Report>\n");
        buffer.append("  <Header>\n");
        buffer.append("    <DepId>"+ehm.getDepId()+"</DepId>\n");
        buffer.append("    <ExportDate>"+ehm.getExportDate()+"</ExportDate>\n");
        buffer.append("  </Header>\n");
    }

    /**
     * 构建输出文件的Body部分
     *
     * @param mapData 要输出的数据的内容
     */
    @Override
    public void buildBody(Map<String, Collection<ExportDataModel>> mapData) {
        buffer.append("  <Body>\n");
        for(String tblName : mapData.keySet()){
            //先拼接表名称
            buffer.append("    <Datas TableName=\""+tblName+"\">\n");
            //然后循环拼接具体数据
            for(ExportDataModel edm : mapData.get(tblName)){
                buffer.append("      <Data>\n");
                buffer.append("        <ProductId>"+edm.getProductId()+"</ProductId>\n");
                buffer.append("        <Price>"+edm.getPrice()+"</Price>\n");
                buffer.append("        <Amount>"+edm.getAmount()+"</Amount>\n");
                buffer.append("      </Data>\n");
            }
            buffer.append("    </Datas>\n");
        }
        buffer.append("  </Body>\n");
    }

    /**
     * 构建输出文件的Footer部分
     *
     * @param efm 文件尾的内容
     */
    @Override
    public void buildFooter(ExportFooterModel efm) {
        buffer.append("  <Footer>\n");
        buffer.append("    <ExportUser>"+efm.getExportUser()+"</ExportUser>\n");
        buffer.append("  </Footer>\n");
        buffer.append("</Report>\n");
    }

    public StringBuffer getResult(){
        return buffer;
    }
}