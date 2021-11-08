package 设计模式.pdai.抽象工厂方法.DAO层;

public class RdbDAOFactory extends DAOFactory{
    public OrderDetailDAO createOrderDetailDAO() {
        return new RdbDetailDAOImpl();
    }
    public OrderMainDAO createOrderMainDAO() {
        return new RdbMainDAOImpl();
    }
}
