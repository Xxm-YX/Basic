package 设计模式.pdai.工厂方法模式;

import 设计模式.pdai.简单工厂模式.传统方法.Product;

/**
 * Creator
 *
 * 高层组件
 */
public abstract class ExportOperate {
    /**
       * 导出文件
       * @param data 需要保存的数据
       * @return 是否成功导出文件
       */
    public boolean export(String data){
        //使用工厂方法
        ExportFileApi api = factoryMethod();
        return api.export(data);
    }
    /**
     * 工厂方法，创建导出的文件对象的接口对象
     * @return 导出的文件对象的接口对象
     */
    protected abstract ExportFileApi factoryMethod();
}
