package work.ccpw.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import work.ccpw.domain.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-27 19:51
 **/
public class JacksonTest {

    @Test
    public void test1() throws IOException {
        // 1.创建Person对象`
        Person person = new Person();
        person.setName("张三");
        person.setAge(24);
        person.setGender("男");

        // 2.创建Jackson的核心对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        // 3.转换
        /*
                转换方法:
                    writeValue(参数1,obj);
                        参数1:
                            File: 将obj对象转换为JSON字符串,并保存到指定的文件中
                            Writer:将obj对象转换为JSON字符串,并将json数据填充到字符输出流中
                            OutputStream:将obj对象转换为JSON字符串,并将json数据填充到字节输出流中
                    writeValueAsString(obj) : 将对象转为json字符串
         */
        String json = objectMapper.writeValueAsString(person);
        // {"name":"张三","age":24,"gender":"男"}
//        System.out.println(json);

        // writeValue,将数据写到d://a.txt
        objectMapper.writeValue(new File("a.txt"), person);

        // writeValue将数据关联到writer中
        objectMapper.writeValue(new FileWriter("b.txt"), person);
    }

    @Test
    public void test2() throws IOException {
        // 1.创建Person对象`
        Person person = new Person();
        person.setName("张三");
        person.setAge(24);
        person.setGender("男");
        person.setDate(new Date());

        // 2.转换
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(person);
        System.out.println(json);
    }

    @Test
    public void test3() throws IOException {
        // 1.创建Person对象`
        Person person1 = new Person();
        person1.setName("张三");
        person1.setAge(24);
        person1.setGender("男");
        person1.setDate(new Date());

        Person person2 = new Person();
        person2.setName("张三");
        person2.setAge(24);
        person2.setGender("男");
        person2.setDate(new Date());

        Person person3 = new Person();
        person3.setName("张三");
        person3.setAge(24);
        person3.setGender("男");
        person3.setDate(new Date());

        // 创建List集合
        ArrayList<Person> ps = new ArrayList<Person>();
        ps.add(person1);
        ps.add(person2);
        ps.add(person3);
        // 2.转换
        ObjectMapper mapper = new ObjectMapper();

        // [{"name":"张三","age":24,"gender":"男","date":"2020-06-27"},{"name":"张三","age":24,"gender":"男","date":"2020-06-27"},{"name":"张三","age":24,"gender":"男","date":"2020-06-27"}]
        String json = mapper.writeValueAsString(ps);
        System.out.println(json);
    }

    @Test
    public void test4() throws IOException {
        // 1.创建map对象`
        HashMap<Object, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 24);
        map.put("gender", "男");
        // 2.转换
        ObjectMapper mapper = new ObjectMapper();

        // {"gender":"男","name":"张三","age":24}
        String json = mapper.writeValueAsString(map);
        System.out.println(json);
    }

    /**
     * 演示 JSON字符串转为Java对象
     */
    @Test
    public void test5() throws JsonProcessingException {
        // 1. 初始化JSON对象
        String json = "{'gender':'男','name':'张三','age':24}";

        // 2. 创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();

        // 2. 转化为Java对象 Person对象
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);
    }
}
