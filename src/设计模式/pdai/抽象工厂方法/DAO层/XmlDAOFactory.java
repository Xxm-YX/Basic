package 设计模式.pdai.抽象工厂方法.DAO层;

/**
 * Xml实现方式的工厂
 */
public class XmlDAOFactory extends DAOFactory{
    public OrderDetailDAO createOrderDetailDAO() {
        return new XmlDetailDAOImpl();
    }
    public OrderMainDAO createOrderMainDAO() {
        return new XmlMainDAOImpl();
    }
}
