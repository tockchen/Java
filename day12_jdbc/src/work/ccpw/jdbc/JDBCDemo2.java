package work.ccpw.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: Entry
 * @description: account表 添加一条记录 insert
 * @author: cone
 * @create: 2020-06-18 15:52
 **/
public class JDBCDemo2 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.定义sql语句
            String sql = "insert into account values(null,'王五',3000)";
            // 3. 获取Connection对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?useUnicode=true&characterEncoding=utf8", "root", "root");
            // 4. 获取执行sql的对象 Statement
            stmt = conn.createStatement();
            // 5. 执行sql语句
            int count = stmt.executeUpdate(sql);
            // 6. 处理结果
            System.out.println(count);
            if (count > 0){
                System.out.println("添加成功!");
            }else{
                System.out.println("添加失败!");
            }
        }  catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            // stmt.clost();
            // 7. 释放资源
            // 避免空指针异常
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
