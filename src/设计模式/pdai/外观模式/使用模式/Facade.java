package 设计模式.pdai.外观模式.使用模式;

import 设计模式.pdai.外观模式.不用模式解决.Business;
import 设计模式.pdai.外观模式.不用模式解决.DAO;
import 设计模式.pdai.外观模式.不用模式解决.Presentation;

public class Facade {

    /**
     * 客户端需要的，一个简单的调用代码生成的功能
     */
    public void generate(){
        new Presentation().generate();
        new Business().generate();
        new DAO().generate();
    }
}
