package 设计模式.pdai.代理模式.不使用模式;

import java.util.Collection;

public class Client {
    public static void main(String[] args) throws Exception{
        UserManager userManager = new UserManager();
        Collection<UserModel> col = userManager.getUserByDepId("0101");
        System.out.println(col);
    }
}