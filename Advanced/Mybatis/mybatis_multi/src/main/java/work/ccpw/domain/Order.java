package work.ccpw.domain;



import java.util.Date;

/**
 * @program: Mybatis
 * @description:
 * @author: Andy
 * @create: 2020-07-06 21:20
 **/
public class Order {
    private Integer id;
    private Date orderTime;
    private double total;
    /**
     * 当前用户属于那个用户
     */
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderTime=" + orderTime +
                ", total=" + total +
                ", user=" + user +
                '}';
    }
}
