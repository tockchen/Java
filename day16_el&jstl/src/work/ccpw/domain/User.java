package work.ccpw.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-23 17:46
 **/
public class User {
    private String name;
    private int age;
    private Date birthday;

    public User(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
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
    /**
     * 逻辑视图
     * @return 格式化日期或者空
     */
    public String getBirStr(){

        if(birthday != null){
            //1.格式化日期对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //2.返回字符串即可
            return sdf.format(birthday);

        }else{
            return "";
        }
    }
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
