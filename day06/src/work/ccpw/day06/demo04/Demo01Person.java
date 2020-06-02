package work.ccpw.day06.demo04;

/**
 * @program: Entry
 * @description: 测试类
 * @author: cone
 * @create: 2020-06-02 14:43
 **/
public class Demo01Person {
    public static void main(String[] args) {
        Person person = new Person();
        // 设置我自己的名字
        person.name = "王健林";
        person.sayHello("王思聪");


        // 地址值
        System.out.println(person);
    }
}
