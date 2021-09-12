package 设计模式.单例模式.src.枚举;

/**
 * 利用枚举的方式 实现单例
 *
 * Android不推荐
 *
 * Effective JAVA 推荐方法
 *
 * 保证线程安全和单一实例的问题
 */
public enum  EnumMode {

    INSTANCE;

    private int id;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public static void main(String[] args) {
        EnumMode.INSTANCE.setId(1);
        System.out.println(EnumMode.INSTANCE.getId());
    }
}
