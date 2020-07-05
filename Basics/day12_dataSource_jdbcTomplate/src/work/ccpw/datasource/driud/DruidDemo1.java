package work.ccpw.datasource.driud;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @program: Entry
 * @description:  Druid演示
 * @author: cone
 * @create: 2020-06-18 23:43
 **/
public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        // 1. 导入jar包
        // 2. 定义配置文件
        // 3. 加载配置文件
        Properties pro = new Properties();
        InputStream is = DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        // 4. 获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        // 5. 获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);

    }
}
