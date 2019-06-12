package com.inspur.datasource;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.inspur.datasource.OrderDataSourceConfig;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Order: YANG
 * Date: 2019/6/12-12:59
 * Description: No Description
 */
@Configuration
@MapperScan(basePackages = "com.inspur.order.mapper",sqlSessionTemplateRef = "OrderSqlSessionTemplate")
public class MyBatisOrderDataSourceConfig {

    //配置数据源
    @Bean(name = "OrderDataSource")
    public DataSource OrderDataSource(OrderDataSourceConfig orderDataSourceConfig) throws SQLException {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setURL(orderDataSourceConfig.getUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword(orderDataSourceConfig.getPassword());
        mysqlXADataSource.setUser(orderDataSourceConfig.getUsername());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);

        //创建atomikos全局事务
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXADataSource);
        xaDataSource.setUniqueResourceName("OrderDataSource");

        xaDataSource.setMinPoolSize(orderDataSourceConfig.getMinPoolSize());
        xaDataSource.setMaxPoolSize(orderDataSourceConfig.getMaxPoolSize());
        xaDataSource.setMaxLifetime(orderDataSourceConfig.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(orderDataSourceConfig.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(orderDataSourceConfig.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(orderDataSourceConfig.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(orderDataSourceConfig.getMaxIdleTime());
        xaDataSource.setTestQuery(orderDataSourceConfig.getTestQuery());
        return xaDataSource;
    }

    @Bean(name = "OrderSqlSessionFactory")
    public SqlSessionFactory OrderSqlSessionFactory(@Qualifier("OrderDataSource") DataSource dataSource)
            throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "OrderSqlSessionTemplate")
    public SqlSessionTemplate OrderSqlSessionTemplate(
            @Qualifier("OrderSqlSessionFactory") SqlSessionFactory sqlSessionFactory)throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
