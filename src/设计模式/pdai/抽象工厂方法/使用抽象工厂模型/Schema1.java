package 设计模式.pdai.抽象工厂方法.使用抽象工厂模型;

import 设计模式.pdai.抽象工厂方法.CPUApi;
import 设计模式.pdai.抽象工厂方法.GAMainboard;
import 设计模式.pdai.抽象工厂方法.IntelCPU;
import 设计模式.pdai.抽象工厂方法.MainboardApi;

/**
 * 装机方案一：Intel 的CPU + 技嘉的主板
 * 这里创建CPU和主板对象的时候，是对应的，能匹配上的
 */
public class Schema1 implements AbstractFactory{
    public CPUApi createCPUApi() {
        return new IntelCPU(1156);
    }
    public MainboardApi createMainboardApi() {
        return new GAMainboard(1156);
    }
}