package work.ccpw.day07.demo13;

/**
 * @program: Entry
 * @description: 游戏当中的英雄角色类
 * @author: cone
 * @create: 2020-06-03 13:40
 **/
public class Hero {
    /**
     * 英雄的名字
     */
    private String name;
    /**
     * 英雄的年龄
     */
    private int age;
    /**
     * 英雄的武器
     */
    private Weapon weapon;

    public Hero() {
    }

    public Hero(String name, int age, Weapon weapon) {
        this.name = name;
        this.age = age;
        this.weapon = weapon;
    }

    public void attack() {
        System.out.println("年龄为" + age + "的" + name + "用" + weapon.getCode() + "攻击敌方。");
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

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
