package 设计模式.pdai.抽象工厂方法.可扩展抽象类型;

import 设计模式.pdai.抽象工厂方法.CPUApi;
import 设计模式.pdai.抽象工厂方法.MainboardApi;

public class ComputerEngineer {

    private CPUApi cpu= null;
    private MainboardApi mainboard = null;
    /**
     * 定义组装机器需要的内存
     */
    private MemoryApi memory = null;
    public void makeComputer(AbstractFactory schema){
        prepareHardwares(schema);
    }

    private void prepareHardwares(AbstractFactory schema){
        //这里要去准备CPU和主板的具体实现，为了示例简单，这里只准备这两个
        //可是，装机工程师并不知道如何去创建，怎么办呢？

        //使用抽象工厂来获取相应的接口对象
        this.cpu = (CPUApi)schema.createProduct(1);
        this.mainboard = (MainboardApi)schema.createProduct(2);
        this.memory = (MemoryApi)schema.createProduct(3);


        //测试一下配件是否好用
        this.cpu.calculate();
        this.mainboard.installCPU();
        if(memory!=null){
            this.memory.cacheData();
        }
    }
}
