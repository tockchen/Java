package work.ccpw.day06.demo03;

/**
 * @program: Entry
 * @description: Student测试类 javaBean
 * @author: cone
 * @create: 2020-06-02 14:36
 **/
public class Demo04Student {
    public static void main(String[] args) {
        Student stu = new Student();

        stu.setName("鹿晗");
        stu.setAge(20);
        stu.setMale(true);

        System.out.println("姓名：" + stu.getName());
        System.out.println("年龄：" + stu.getAge());
        System.out.println("是不是爷们儿：" + stu.isMale());
    }
}
