package work.ccpw.day06.demo04;

/**
 * @program: Entry
 * @description: 测试类
 * @author: cone
 * @create: 2020-06-02 14:47
 **/
public class Demo02Student {
    public static void main(String[] args) {
        // 无参构造
        Student stu1 = new Student();
        System.out.println("============");

        // 全参构造
        Student stu2 = new Student("赵丽颖", 20);
        System.out.println("姓名：" + stu2.getName() + "，年龄：" + stu2.getAge());
        // 如果需要改变对象当中的成员变量数据内容，仍然还需要使用setXxx方法
        stu2.setAge(21);
        System.out.println("姓名：" + stu2.getName() + "，年龄：" + stu2.getAge());

    }
}
