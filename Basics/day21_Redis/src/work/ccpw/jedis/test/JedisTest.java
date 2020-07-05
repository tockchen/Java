package work.ccpw.jedis.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import work.ccpw.jedis.utils.JedisPoolUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: Entry
 * @description: jedis的测试类
 * @author: cone
 * @create: 2020-06-27 23:15
 **/
public class JedisTest {

    /**
     * 快速入门
     */
    @Test
    public void test1() {
        // 1.获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 2. 操作
        jedis.set("username", "root");
        jedis.set("password", "root");
        // 3. 关闭连接
        jedis.close();
    }

    /**
     * string 数据结构操作
     */
    @Test
    public void test2() {
        // 1.获取连接 如果使用空参构造  默认值 "localhost",6379端口
        Jedis jedis = new Jedis();
        // 2. 操作
        // 2.1 存储
        jedis.set("username", "root");
        // 2.2 获取
        String username = jedis.get("username");
        System.out.println(username);

        // 可用使用setex()方法存储可以指定过期时间的 key value
        // 将activecode ,hehe键值对存入redis,并且20秒后自动删除该键值对
        jedis.setex("activecode", 20, "hehe");
        // 3. 关闭连接
        jedis.close();
    }

    /**
     * hash 数据结构操作
     */
    @Test
    public void testHash() {
        // 1.获取连接 如果使用空参构造  默认值 "localhost",6379端口
        Jedis jedis = new Jedis();
        // 2. 操作
        // 2.1 存储
        jedis.hset("user", "username", "cc");
        jedis.hset("user", "age", "23");
        jedis.hset("user", "gender", "男");
        // 2.2 获取
        String username = jedis.hget("user", "username");
        System.out.println(username);

        // 获取hash的所有map中的数据
        Map<String, String> user = jedis.hgetAll("user");
        // keyset
        Set<String> keySet = user.keySet();
        for (String key : keySet) {
            String value = user.get(key);
            System.out.println(key + " : " + value);
        }

        // 3. 关闭连接
        jedis.close();
    }


    /**
     * List 数据结构操作
     */
    @Test
    public void testList() {
        // 1.获取连接 如果使用空参构造  默认值 "localhost",6379端口
        Jedis jedis = new Jedis();
        // 2. 操作
        // 2.1 存储
        // 2.1.1 从左边存 cba
        jedis.lpush("mylist","a","b","c");
        // 2.1.2 从右边存 abc
        jedis.rpush("mylist","a","b","c");
        // 2.2 获取 范围获取  获取所有
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);
        // list 弹出
        String element1 = jedis.lpop("mylist");
        System.out.println(element1);
        String element2 = jedis.rpop("mylist");
        System.out.println(element2);

        List<String> mylist1 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist1);
        // 3. 关闭连接
        jedis.close();
    }
    /**
     * Set 数据结构操作
     */
    @Test
    public void testSet() {
        // 1.获取连接 如果使用空参构造  默认值 "localhost",6379端口
        Jedis jedis = new Jedis();
        // 2. 操作
        // 2.1 存储
        jedis.sadd("mySet","java","php","c++");
        // 2.2 获取
        Set<String> mySet = jedis.smembers("mySet");
        System.out.println(mySet);
        for (String value : mySet) {
            System.out.println(value);
        }
        // 3. 关闭连接
        jedis.close();
    }

    /**
     * SortedSet 数据结构操作
     */
    @Test
    public void testSortedSet() {
        // 1.获取连接 如果使用空参构造  默认值 "localhost",6379端口
        Jedis jedis = new Jedis();
        // 2. 操作
        // 2.1 存储
        jedis.zadd("mySortedSet",3,"亚瑟");
        jedis.zadd("mySortedSet",30,"后羿");
        jedis.zadd("mySortedSet",55,"孙悟空");
        // 2.2 获取
        Set<String> mySortedSet = jedis.zrange("mySortedSet", 0, -1);
        System.out.println(mySortedSet);
        // 3. 关闭连接
        jedis.close();
    }

    /**
     * jedis连接池使用
     */
    @Test
    public void testJedisPool() {
        // 0. 创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        // 1. 创建Jedis连接池对象
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);
        // 2.获取连接
        Jedis jedis = jedisPool.getResource();
        // 2. 使用
        jedis.set("hehe","heihei");

        // 3. 关闭 归还到连接池中
        jedis.close();

    }

    /**
     * jedis连接池工具类使用
     */
    @Test
    public void testJedisPoolUtil() {
        // 0. 通过连接池工具类获取
        Jedis jedis = JedisPoolUtils.getJedis();
        // 2. 使用
        jedis.set("word","heihei");

        // 3. 关闭 归还到连接池中
        jedis.close();

    }
}
