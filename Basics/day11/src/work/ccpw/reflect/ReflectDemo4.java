package work.ccpw.reflect;

import work.ccpw.domain.Person;

import java.lang.reflect.Method;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-17 12:28
 **/
public class ReflectDemo4 {
    /**
     * Class对象功能：
     *   * 获取功能：
     *   1. 获取成员变量们
     *       * Field[] getFields()
     *       * Field getField(String name)
     *
     *       * Field[] getDeclaredFields()
     *       * Field getDeclaredField(String name)
     *   2. 获取构造方法们
     *       * Constructor<?>[] getConstructors()
     *       * Constructor<T> getConstructor(类<?>... parameterTypes)
     *
     *       * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
     *       * Constructor<?>[] getDeclaredConstructors()
     *   3. 获取成员方法们：
     *       * Method[] getMethods()
     *       * Method getMethod(String name, 类<?>... parameterTypes)
     *
     *       * Method[] getDeclaredMethods()
     *       * Method getDeclaredMethod(String name, 类<?>... parameterTypes)
     *
     *   4. 获取类名
     *       * String getName()
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // 0.获取Person的Class对象
        Class personClass = Person.class;
        /*
          3. 获取成员方法们：
             * Method[] getMethods()
             * Method getMethod(String name, 类<?>... parameterTypes)

             * Method[] getDeclaredMethods()
             * Method getDeclaredMethod(String name, 类<?>... parameterTypes)
         */
        // 获取指定名称的方法
        Method eat_method = personClass.getMethod("eat");
        Person p = new Person();
        // 执行方法
        eat_method.invoke(p);


        Method eat_method2 = personClass.getMethod("eat", String.class);
        // 执行方法
        eat_method2.invoke(p,"饭");

        System.out.println("-----------------");

        // 获取所有public修饰的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
            // method.setAccessible(true);
        }

        // 获取类名
        String className = personClass.getName();
        // work.ccpw.day11.dome01.domain.Person
        System.out.println(className);

    }
}
