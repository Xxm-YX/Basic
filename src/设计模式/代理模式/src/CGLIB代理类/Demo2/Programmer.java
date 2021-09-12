package 设计模式.代理模式.src.CGLIB代理类.Demo2;

//目标类
public class Programmer {

    private String name;

    public void setName(String name){
        System.out.println("Setting Name.");
        this.name = name;
    }
    public void code(){
        System.out.println(name + " is writing bugs.");
    }
}
