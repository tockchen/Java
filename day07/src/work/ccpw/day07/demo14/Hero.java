package work.ccpw.day07.demo14;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-03 13:44
 **/
public class Hero {
    /**
     * 英雄的名称
     */
    private String name;
    /**
     * 英雄的技能
     */
    private Skill skill;

    public Hero() {
    }

    public Hero(String name, Skill skill) {
        this.name = name;
        this.skill = skill;
    }

    public void attack() {
        System.out.println("我叫" + name + "，开始施放技能：");
        skill.use(); // 调用接口中的抽象方法
        System.out.println("施放技能完成。");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
