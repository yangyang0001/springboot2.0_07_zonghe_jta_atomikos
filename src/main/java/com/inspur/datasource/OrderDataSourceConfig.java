package com.inspur.datasource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * User: YANG
 * Date: 2019/6/12-12:55
 * Description: No Description
 */
@Data
@ConfigurationProperties(prefix = "mysql.datasource.order")
public class OrderDataSourceConfig {
    private String url;
    private String username;
    private String password;
    private int minPoolSize;
    private int maxPoolSize;
    private int maxLifetime;
    private int borrowConnectionTimeout;
    private int loginTimeout;
    private int maintenanceInterval;
    private int maxIdleTime;
    private String testQuery;
}
