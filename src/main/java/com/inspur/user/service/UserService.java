package com.inspur.user.service;

import com.inspur.entity.Order;
import com.inspur.entity.User;
import com.inspur.order.mapper.OrderMapper;
import com.inspur.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * User: YANG
 * Date: 2019/6/13-3:10
 * Description: No Description
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    public int insertUser(String username, Integer age){
        int insertCount = userMapper.insertUser(username, age);
        return insertCount;
    }

    public User getUserByUserName(String username) {
        return userMapper.getUserByUserName(username);
    }


    //这里设计到了不同数据库的事务的操作!这段 代码就出现了 不同数据库 下存在的 分布式事务的 问题
    @Transactional
    public int insertUserAndOrder() {
        Order order = new Order();
        order.setOrderName("B2隐形轰炸机");
        order.setOrderNo("0002");
        order.setPrice(5000d);
        order.setOrderTime(new Date());
        int insertOrderCount = orderMapper.insertOrder(order);

        User user = new User();
        user.setUsername("YangYang0001");
        user.setAge(22);
        int insertUserCount = userMapper.insertUser(user.getUsername(), user.getAge());

        int i = 1/0;
        return insertOrderCount + insertOrderCount;
    }
}
