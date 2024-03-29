package 设计模式.pdai.装饰者模式.AOP;

/**
 * 装饰器的接口，需要跟被装饰的对象实现同样的接口
 */
public abstract class Decorator implements GoodsSaleEbi{
    /**
     * 持有被装饰的组件对象
     */
    protected GoodsSaleEbi ebi;
    /**
     * 通过构造方法传入被装饰的对象
     * ebi被装饰的对象
     */
    public Decorator(GoodsSaleEbi ebi){
        this.ebi = ebi;
    }
}