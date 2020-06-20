package work.ccpw.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: Entry
 * @description: Jdbc入门
 * @author: cone
 * @create: 2020-06-18 15:16
 **/
public class JdbcDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. 导入驱动jar包
        // 2. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 3.获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3",
                "root", "root");
        // 4.定义sql语句
        String sql = "update account set balance = 500 where id = 1";
        // 5.获取执行sql对象 Statement
        Statement statement = conn.createStatement();
        // 6.执行sql语句
        int count = statement.executeUpdate(sql);
        // 7.处理结果
        System.out.println(count);
        // 8.释放资源
        statement.close();
        conn.close();
    }
}
