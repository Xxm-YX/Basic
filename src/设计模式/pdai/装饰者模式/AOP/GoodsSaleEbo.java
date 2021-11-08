package 设计模式.pdai.装饰者模式.AOP;

public class GoodsSaleEbo implements GoodsSaleEbi{
    public boolean sale(String user,String customer, SaleModel saleModel) {
        System.out.println(user+"保存了"+customer+"购买 "+saleModel+" 的销售数据");
        return true;
    }
}
