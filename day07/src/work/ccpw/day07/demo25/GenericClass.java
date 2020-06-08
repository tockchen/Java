package work.ccpw.day07.demo25;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-03 15:24
 **/
public class GenericClass<E> {
    private E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}
