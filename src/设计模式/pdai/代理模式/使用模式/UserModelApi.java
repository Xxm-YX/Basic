package 设计模式.pdai.代理模式.使用模式;

/**
 * 定义用户数据对象的接口
 */
public interface UserModelApi {
    public String getUserId();
    public void setUserId(String userId);
    public String getName();
    public void setName(String name);
    public String getDepId();
    public void setDepId(String depId);
    public String getSex();
    public void setSex(String sex);
}