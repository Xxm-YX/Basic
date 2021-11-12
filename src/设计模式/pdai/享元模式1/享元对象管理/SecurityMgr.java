package 设计模式.pdai.享元模式1.享元对象管理;

import java.util.ArrayList;
import java.util.Collection;

public class SecurityMgr {
    private static SecurityMgr securityMgr = new SecurityMgr();
    private SecurityMgr(){
        FlyweightFactory factory = FlyweightFactory.getInstance();
    }
    public static SecurityMgr getInstance(){
        return securityMgr;
    }
    /**
     * 判断某用户对某个安全实体是否拥有某权限
     * @param user 被检测权限的用户
     * @param securityEntity 安全实体
     * @param permit 权限
     * @return true表示拥有相应权限，false表示没有相应权限
     */
    public boolean hasPermit(String user,String securityEntity,String permit){
        Collection<Flyweight> col = this.queryByUser(user);
        if(col==null || col.size()==0){
            System.out.println(user+"没有登录或是没有被分配任何权限");
            return false;
        }
        for(Flyweight fm : col){
            if(fm.match(securityEntity, permit)){
                return true;
            }
        }
        return false;
    }
    /**
     * 从数据库中获取某人所拥有的权限
     * @param user 需要获取所拥有的权限的人员
     * @return 某人所拥有的权限
     */
    private Collection<Flyweight> queryByUser(String user){
        Collection<Flyweight> col = new ArrayList<Flyweight>();

        for(String s : TestDB.colDB){
            String ss[] = s.split(",");
            if(ss[0].equals(user)){
                Flyweight fm = null;
                if(ss[3].equals("2")){
                    //表示是组合
                    fm = new UnsharedConcreteFlyweight();
                    //获取需要组合的数据
                    String tempSs[] = TestDB.mapDB.get(ss[1]);
                    for(String tempS : tempSs){
                        Flyweight tempFm = FlyweightFactory.getInstance().getFlyweight(tempS);
                        //把这个对象加入到组合对象中
                        fm.add(tempFm);
                    }
                }else{
                    fm = FlyweightFactory.getInstance().getFlyweight(ss[1]+","+ss[2]);
                }

                col.add(fm);
            }
        }
        return col;
    }
}