package 设计模式.pdai.责任链模式.多种请求;

public class Client {
    public static void main(String[] args) {
        //先要组装职责链
        Handler h1 = new GeneralManager();
        Handler h2 = new DepManager();
        Handler h3 = new ProjectManager();
        h3.setSuccessor(h2);
        h2.setSuccessor(h1);

        //开始测试申请聚餐费用
        FeeRequestModel frm = new FeeRequestModel();
        frm.setFee(300);
        frm.setUser("小李");
        //调用处理
        String ret1 = (String)h3.handleRequest(frm);
        System.out.println("ret1="+ret1);

        //重新设置申请金额，再调用处理
        frm.setFee(800);
        h3.handleRequest(frm);
        String ret2 = (String)h3.handleRequest(frm);
        System.out.println("ret2="+ret2);

        //重新设置申请金额，再调用处理
        frm.setFee(1600);
        h3.handleRequest(frm);
        String ret3 = (String)h3.handleRequest(frm);
        System.out.println("ret3="+ret3);
    }
}