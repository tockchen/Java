package work.ccpw.day10.demo19.Stream;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-09 21:02
 **/
public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
