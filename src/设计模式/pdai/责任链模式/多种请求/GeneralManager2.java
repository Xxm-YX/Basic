package 设计模式.pdai.责任链模式.多种请求;

public class GeneralManager2 extends GeneralManager{

    public Object handleRequest(RequestModel rm){
        if(PreFeeRequestModel.FEE_TYPE.equals(rm.getType())){
            //表示预支差旅费用申请
            return myHandler(rm);
        }else{
            //其它的让父类去处理
            return super.handleRequest(rm);
        }
    }
    private Object myHandler(RequestModel rm) {
        //先把通用的对象造型回来
        PreFeeRequestModel frm = (PreFeeRequestModel)rm;
        //项目经理的权限比较小，只能在5000以内
        if(frm.getFee() >= 10000){
            //工作需要嘛，统统同意
            System.out.println("项目经理同意"+frm.getUser()+"预支差旅费用"+frm.getFee()+"元的请求");
            return true;
        }else{
            //超过5000，继续传递给级别更高的人处理
            if(this.successor!=null){
                return this.successor.handleRequest(rm);
            }
        }
        return false;
    }
}
