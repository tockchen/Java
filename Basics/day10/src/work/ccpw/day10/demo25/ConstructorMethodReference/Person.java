package work.ccpw.day10.demo25.ConstructorMethodReference;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-09 21:13
 **/
public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
