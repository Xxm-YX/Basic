package 设计模式.pdai.抽象工厂方法.DAO层;

public class XmlMainDAOImpl implements OrderMainDAO{
    /**
     * 示意方法，保存订单主记录
     */
    @Override
    public void saveOrderMain() {
        System.out.println("now in XmlMainDAOImpl saveOrderMain");
    }
}
