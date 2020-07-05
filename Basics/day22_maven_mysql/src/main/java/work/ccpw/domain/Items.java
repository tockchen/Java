package work.ccpw.domain;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-28 15:41
 **/
public class Items {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
