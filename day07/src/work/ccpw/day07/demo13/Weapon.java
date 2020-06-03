package work.ccpw.day07.demo13;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-03 13:41
 **/
public class Weapon {
    /**
     * 武器的代号
     */
    private String code;

    public Weapon() {
    }

    public Weapon(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
