package work.ccpw.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: Entry
 * @description: 执行DDL语句
 * @author: cone
 * @create: 2020-06-18 16:20
 **/
public class JDBCDemo5 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
            // 3. 定义sql
            String sql  = "create table student (id int , name varchar(20))";
            // 4. 获取执行sql对象
            stmt = conn.createStatement();
            // 5. 执行sql
            int count = stmt.executeUpdate(sql);
            // 6. 处理结果
            System.out.println(count);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 7. 释放资源
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
