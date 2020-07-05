package work.ccpw.jedis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @program: Entry
 * @description: JedisPool工具类
 * @author: cone
 * @create: 2020-06-27 23:59
 * <p>
 * 加载配置文件,配置连接池的参数
 * 提供获取连接池的方法
 **/
public class JedisPoolUtils {
    private static JedisPool jedisPool;

    static {
        //读取配置文件
        try {
            InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
            System.out.println(is);
            //创建Properties对象
            Properties pro = new Properties();
            //关联文件
            pro.load(is);

            //获取数据，设置到JedisPoolConfig中
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
            config.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));
            //初始化JedisPool
            jedisPool = new JedisPool(config, pro.getProperty("host"), Integer.parseInt(pro.getProperty("port")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接方法
     *
     * @return jedis 对象
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
