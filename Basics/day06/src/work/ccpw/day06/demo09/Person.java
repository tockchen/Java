package work.ccpw.day06.demo09;

/**
 * @program: Entry
 * @description: penson类
 * @author: cone
 * @create: 2020-06-02 16:13
 **/
public class Person {
    private String name;
    private int age;

    public Person() {
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
