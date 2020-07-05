package work.ccpw.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * @program: Entry
 * @description:
 * @author: cone
 * @create: 2020-06-27 19:50
 **/
public class Person {
    private String name;
    private int age;
    private String gender;


   // @JsonIgnore 忽略该属性
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    /**
     * 忽略该属性
     * @return Date
     */
    //@JsonIgnore
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
