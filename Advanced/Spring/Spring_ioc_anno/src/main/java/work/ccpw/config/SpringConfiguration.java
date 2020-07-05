package work.ccpw.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * @program: Spring
 * @description:
 * @author: cone
 * @create: 2020-07-01 14:15
 **/
// 标志该类是Spring的核心配置类
@Configuration
//<!--配置注解的组件扫描-->
//<context:component-scan base-package="work.ccpw"/>
@ComponentScan("work.ccpw")
//<import resource="applicationCotext.xml"/>
@Import({DataConfiguration.class})
public class SpringConfiguration {

}
