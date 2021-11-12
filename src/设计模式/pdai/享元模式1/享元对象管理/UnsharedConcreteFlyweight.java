package 设计模式.pdai.享元模式1.享元对象管理;

import java.util.ArrayList;
import java.util.List;

public class UnsharedConcreteFlyweight implements Flyweight{
    /**
     * 记录每个组合对象所包含的子组件
     */
    private List<Flyweight> list = new ArrayList<Flyweight>();

    public void add(Flyweight f) {
        list.add(f);
    }

    public boolean match(String securityEntity, String permit) {
        for(Flyweight f : list){
            //递归调用
            if(f.match(securityEntity, permit)){
                return true;
            }
        }
        return false;
    }
}