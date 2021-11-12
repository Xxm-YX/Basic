package 设计模式.pdai.享元模式1.使用模式;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂，通常实现成为单例
 */
public class FlyweightFactory {
    private static FlyweightFactory factory = new FlyweightFactory();
    private FlyweightFactory(){
    }
    public static FlyweightFactory getInstance(){
        return factory;
    }
    /**
     * 缓存多个flyweight对象
     *
     * 存放  享元对象的名字，享元对象
     */
    private Map<String,Flyweight> fsMap = new HashMap<String,Flyweight>();
    /**
     * 获取key对应的享元对象
     * @param key 获取享元对象的key
     * @return key对应的享元对象
     */
    public Flyweight getFlyweight(String key) {
        Flyweight f = fsMap.get(key);
        if(f==null){
            f = new AuthorizationFlyweight(key);
            fsMap.put(key,f);
        }
        return f;
    }
}
