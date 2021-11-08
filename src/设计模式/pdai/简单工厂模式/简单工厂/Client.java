package 设计模式.pdai.简单工厂模式.简单工厂;

import 设计模式.pdai.简单工厂模式.传统方法.Product;

public class Client {

    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(1);
        // do something with the product
    }
}
