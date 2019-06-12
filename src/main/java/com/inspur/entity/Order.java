package com.inspur.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * User: YANG
 * Date: 2019/6/11-21:50
 * Description: No Description
 */
@Data
public class Order implements Serializable {

    private static final long serialVersionUID = -7729659234977778231L;
    private Long id;
    private String orderName;
    private String orderNo;
    private Double price;
    private Date orderTime;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderName='" + orderName + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", price=" + price +
                ", orderTime=" + orderTime +
                '}';
    }
}
