package com.inspur.order.service;

import com.inspur.entity.Order;
import com.inspur.order.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: YANG
 * Date: 2019/6/11-21:52
 * Description: No Description
 */
@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    public int insertOrder(Order order) {
        int insertCount = orderMapper.insertOrder(order);
        log.info("insertOrderCount -----------:" + insertCount);
        return insertCount;
    }


}
