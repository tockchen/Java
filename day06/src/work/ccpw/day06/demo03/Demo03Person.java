package work.ccpw.day06.demo03;

/**
 * @program: Entry
 * @description: penson类测试类
 * @author: cone
 * @create: 2020-06-02 14:25
 **/
public class Demo03Person {
    public static void main(String[] args) {
        Person person = new Person();
        person.show();

        person.name = "赵丽颖";
//        person.age = -20; // 直接访问private内容，错误写法！
        person.setAge(20);
        person.show();
    }
}
