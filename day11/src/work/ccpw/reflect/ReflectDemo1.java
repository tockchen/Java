package work.ccpw.reflect;

import work.ccpw.domain.Person;
import work.ccpw.domain.Student;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-17 11:53
 **/
public class ReflectDemo1 {
    /**
     * 获取Class对象的方式：
     *   1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
     *   2. 类名.class：通过类名的属性class获取
     *   3. 对象.getClass()：getClass()方法在Object类中定义着。
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // 1.Class.forName("全类名")
        Class cls1 = Class.forName("work.ccpw.domain.Person");
        // work.ccpw.day11.dome01.domain.Person
        System.out.println(cls1);
        // 2.类名.class
        Class cls2 = Person.class;
        // work.ccpw.day11.dome01.domain.Person
        System.out.println(cls2);
        // 3.对象.getClass()
        Person p = new Person();
        Class cls3 = p.getClass();
        // work.ccpw.day11.dome01.domain.Person
        System.out.println(cls3);


        //== 比较三个对象
        // true
        System.out.println(cls1 == cls2);
        // true
        System.out.println(cls1 == cls3);

        Class c = Student.class;
        System.out.println(c == cls1);




    }
}
