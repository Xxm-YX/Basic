package 设计模式.pdai.抽象工厂方法.DAO层;

public class RdbDetailDAOImpl implements OrderDetailDAO{
    public void saveOrderDetail() {
        System.out.println("now in RdbDetailDAOImpl saveOrderDetail");
    }
}