package com.inspur;

import com.inspur.datasource.OrderDataSourceConfig;
import com.inspur.datasource.UserDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * User: YANG
 * Date: 2019/6/13-0:29
 * Description: No Description
 */
@SpringBootApplication
@EnableAsync    //开启异步调用的方式
@EnableConfigurationProperties({UserDataSourceConfig.class, OrderDataSourceConfig.class})
//@MapperScan(basePackages = {"com.inspur.user.mapper","com.inspur.order.mapper"})
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class, args);
    }
}
