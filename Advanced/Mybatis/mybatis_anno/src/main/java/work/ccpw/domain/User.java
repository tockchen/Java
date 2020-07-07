package work.ccpw.domain;

import java.util.Date;
import java.util.List;

/**
 * @program: Mybatis
 * @description:
 * @author: Andy
 * @create: 2020-07-06 21:03
 **/
public class User {
    private Integer id;
    private String username;
    private String password;
    private Date birthday;
    /**
     * 描述当前用户存在哪些订单
     */
//    private List<Order> orderList;

    /**
     * 描述的是当前用户具备哪些角色
     */
    private List<Role> roleList;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", roleList=" + roleList +
                '}';
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

//    public List<Order> getOrderList() {
//        return orderList;
//    }
//
//    public void setOrderList(List<Order> orderList) {
//        this.orderList = orderList;
//    }


}
