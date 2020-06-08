package work.ccpw.Thread.demo01;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-07 17:03
 **/
public class Person {
    private String name;

    public void run(){
        //定义循环,执行20次
        for(int i=0; i<20; i++){
            System.out.println(name+"-->"+i);
        }
    }

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
