package work.ccpw.dao.impl;

import work.ccpw.dao.ItemsDao;
import work.ccpw.domain.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-28 15:46
 **/
public class ItemsDaoImpl implements ItemsDao {
    public List<Items> findAll() {
        List<Items> itemList = new ArrayList<Items>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        // 加载驱动类
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 获取connection对象
            String url="jdbc:mysql://localhost:3306/maven?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
            connection = DriverManager.getConnection(url, "root", "root");
            // 获取真正操作数据库的对象
            ps = connection.prepareCall("select * from items");
            // 执行数据库查询操作
            resultSet = ps.executeQuery();
            // 数据库结果集转换为java的List集合

            while (resultSet.next()) {
                Items items = new Items();
                items.setId(resultSet.getInt("id"));
                items.setName(resultSet.getString("name"));
                itemList.add(items);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps != null){
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return itemList;
    }
}
