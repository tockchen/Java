package work.ccpw.datasource.driud;

import work.ccpw.datasource.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @program: Entry
 * @description: Druid演示
 * @author: cone
 * @create: 2020-06-19 00:22
 **/
public class DruidDemo2 {
    public static void main(String[] args) {
        /*
         * 完成添加操作：给account表添加一条记录
         */
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 1.获取连接
            conn = JDBCUtils.getConnection();
            // 2.定义sql
            String sql = "insert into account values(null,?,?)";
            // 3.获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            // 4.给？赋值
            pstmt.setString(1,"陈灿");
            pstmt.setDouble(2,10000);
            // 5.执行sql
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 6. 释放资源
            JDBCUtils.close(pstmt,conn);
        }
    }
}

