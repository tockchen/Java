package work.ccpw.mapper;

import work.ccpw.domain.Order;

import java.util.List;

/**
 * @program: Mybatis
 * @description:
 * @author: Andy
 * @create: 2020-07-06 21:23
 **/
public interface OrderMapper {

    /**
     * 查询这个订单属于谁
     * @return order
     */
    public List<Order> findAll();
}
