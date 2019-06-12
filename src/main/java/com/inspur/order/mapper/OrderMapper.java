package com.inspur.order.mapper;

import com.inspur.entity.Order;
import org.apache.ibatis.annotations.Insert;

/**
 * User: YANG
 * Date: 2019/6/11-21:53
 * Description: No Description
 */
public interface OrderMapper {

    @Insert("insert into `order` (orderName, orderNo, price, orderTime) values (#{orderName}, #{orderNo}, #{price}, #{orderTime})")
    public int insertOrder(Order order);

}
