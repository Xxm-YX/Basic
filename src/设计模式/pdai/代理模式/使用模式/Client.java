package 设计模式.pdai.代理模式.使用模式;

import java.util.Collection;

public class Client {
    public static void main(String[] args) throws Exception{
        UserManager userManager = new UserManager();
        Collection<UserModelApi> col = userManager.getUserByDepId("0101");

        //如果只是显示用户名称，那么不需要重新查询数据库
        for(UserModelApi umApi : col){
            System.out.println("用户编号：="+umApi.getUserId()+",用户姓名：="+umApi.getName());
        }
        //如果访问非用户编号和用户姓名外的属性，那就会重新查询数据库
        for(UserModelApi umApi : col){
            System.out.println("用户编号：="+umApi.getUserId()+",用户姓名：="+umApi.getName()+",所属部门：="+umApi.getDepId());
        }
    }
}