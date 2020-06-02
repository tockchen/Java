package work.ccpw.day06.demo03;

/**
 * @program: Entry
 * @description: 学生类  javaBean
 * 对于基本类型当中的boolean值，Getter方法一定要写成isXxx的形式，而setXxx规则不变。
 * @author: cone
 * @create: 2020-06-02 14:34
 **/
public class Student {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
    /**
     * 是不是爷们
     */
    private boolean male;

    public void setMale(boolean b) {
        male = b;
    }

    public boolean isMale() {
        return male;
    }

    public void setName(String str) {
        name = str;
    }

    public String getName() {
        return name;
    }

    public void setAge(int num) {
        age = num;
    }

    public int getAge() {
        return age;
    }
}
