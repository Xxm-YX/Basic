package 设计模式.pdai.工厂方法模式;

import 设计模式.pdai.简单工厂模式.传统方法.ConcreteProduct1;
import 设计模式.pdai.简单工厂模式.传统方法.Product;

/**
 * 底层组件
 */
public class ExportDBOperate extends ExportOperate {

    protected ExportFileApi factoryMethod() {
        //创建导出成文本文件格式的对象
        return new ExportTxtFile();
    }
}
