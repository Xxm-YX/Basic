package 设计模式.pdai.代理模式.不使用模式;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 实现示例要求的功能
 */
public class UserManager {
    /**
     * 根据部门编号来获取该部门下的所有人员
     * @param depId 部门编号
     * @return 该部门下的所有人员
     */
    public Collection<UserModel> getUserByDepId(String depId)throws Exception{
        Collection<UserModel> col = new ArrayList<UserModel>();
        Connection conn = null;
        try{
            conn = this.getConnection();
         /*   String sql = "select * from tbl_user u,tbl_dep d "
                    +"where u.depId=d.depId and d.depId like ?";*/

            PreparedStatement pstmt = conn.prepareStatement(/*sql*/null);
            pstmt.setString(1, depId+"%");

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                UserModel um = new UserModel();
                um.setUserId(rs.getString("userId"));
                um.setName(rs.getString("name"));
                um.setDepId(rs.getString("depId"));
                um.setSex(rs.getString("sex"));

                col.add(um);
            }
            rs.close();
            pstmt.close();
        }finally{
            conn.close();
        }
        return col;
    }
    /**
     * 获取与数据库的连接
     * @return 数据库连接
     */
    private Connection getConnection() throws Exception {
        Class.forName("你用的数据库对应的JDBC驱动类");
        return DriverManager.getConnection("连接数据库的URL", "用户名", "密码");
    }
}