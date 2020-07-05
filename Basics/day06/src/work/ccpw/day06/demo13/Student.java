package work.ccpw.day06.demo13;

/**
 * @program: Entry
 * @description: Student类
 * @author: cone
 * @create: 2020-06-02 17:37
 **/
public class Student {
    /**
     * 学号
     */
    private int id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
    /**
     * 所在教室
     */
    static String room;
    /**
     * 学号计数器，每当new了一个新对象的时候，计数器++
     */
    private static int idCounter = 0;

    public Student() {
        this.id = ++idCounter;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = ++idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
