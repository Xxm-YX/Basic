package 设计模式.pdai.抽象工厂方法.可扩展抽象类型;

/**
 * 现代内存的类
 */
public class HyMemory implements MemoryApi{
    public void cacheData() {
        System.out.println("现在正在使用现代内存");
    }
}
