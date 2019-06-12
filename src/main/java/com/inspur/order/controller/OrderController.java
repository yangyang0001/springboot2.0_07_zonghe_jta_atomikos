package com.inspur.order.controller;

import com.inspur.entity.Order;
import com.inspur.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * User: YANG
 * Date: 2019/6/11-21:52
 * Description: No Description
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/insertOrder")
    public String insertOrder() {
        Order order = new Order();
        order.setOrderName("华为8X订单");
        order.setOrderNo("0001");
        order.setPrice(1800d);
        order.setOrderTime(new Date());
        int insertCount = orderService.insertOrder(order);
        return Integer.valueOf(insertCount).toString();
    }
}
