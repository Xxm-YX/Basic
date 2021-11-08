package 设计模式.pdai.生成器模式.不用设计模式的解决方案;

import 设计模式.pdai.生成器模式.ExportDataModel;
import 设计模式.pdai.生成器模式.ExportFooterModel;
import 设计模式.pdai.生成器模式.ExportHeaderModel;

import java.util.Collection;
import java.util.Map;

public class ExportToTxt {

    /**
     * 导出数据到文本文件
     * @param ehm 文件头的内容
     * @param mapData 数据的内容
     * @param efm 文件尾的内容
     */
    public void export(ExportHeaderModel ehm,
                       Map<String, Collection<ExportDataModel>> mapData,
                       ExportFooterModel efm) {
        //用来记录最终输出的文件内容
        StringBuffer buffer = new StringBuffer();
        //1：先来拼接文件头的内容
        buffer.append(ehm.getDepId()+","+ehm.getExportDate()+"\n");
        //2：接着来拼接文件体的内容
        for(String tblName : mapData.keySet()){
            //先拼接表名称
            buffer.append(tblName+"\n");
            //然后循环拼接具体数据
            for(ExportDataModel edm : mapData.get(tblName)){
                buffer.append(edm.getProductId()+","+edm.getPrice()+","+edm.getAmount()+"\n");
            }
        }
        //3：接着来拼接文件尾的内容
        buffer.append(efm.getExportUser());

        //为了演示简洁性，这里就不去写输出文件的代码了
        //把要输出的内容输出到控制台看看
        System.out.println("输出到文本文件的内容：\n"+buffer);
    }
}
