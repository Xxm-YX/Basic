package 设计模式.pdai.抽象工厂方法.使用抽象工厂模型;

import 设计模式.pdai.抽象工厂方法.AMDCPU;
import 设计模式.pdai.抽象工厂方法.CPUApi;
import 设计模式.pdai.抽象工厂方法.MSIMainboard;
import 设计模式.pdai.抽象工厂方法.MainboardApi;

/**
 * 装机方案二：AMD的CPU + 微星的主板
 * 这里创建CPU和主板对象的时候，是对应的，能匹配上的
 */
public class Schema2 implements AbstractFactory{
    public CPUApi createCPUApi() {
        return new AMDCPU(939);
    }
    public MainboardApi createMainboardApi() {
        return new MSIMainboard(939);
    }
}