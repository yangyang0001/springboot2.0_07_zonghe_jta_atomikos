package com.inspur.datasource;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.inspur.datasource.UserDataSourceConfig;
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
 * User: YANG
 * Date: 2019/6/12-12:59
 * Description: No Description
 */
@Configuration
@MapperScan(basePackages = "com.inspur.user.mapper",sqlSessionTemplateRef = "UserSqlSessionTemplate")
public class MyBatisUserDataSourceConfig {

    //配置数据源
    @Bean(name = "UserDataSource")
    public DataSource UserDataSource(UserDataSourceConfig userDataSourceConfig) throws SQLException {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setURL(userDataSourceConfig.getUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword(userDataSourceConfig.getPassword());
        mysqlXADataSource.setUser(userDataSourceConfig.getUsername());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);

        //创建atomikos全局事务
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXADataSource);
        xaDataSource.setUniqueResourceName("UserDataSource");

        xaDataSource.setMinPoolSize(userDataSourceConfig.getMinPoolSize());
        xaDataSource.setMaxPoolSize(userDataSourceConfig.getMaxPoolSize());
        xaDataSource.setMaxLifetime(userDataSourceConfig.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(userDataSourceConfig.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(userDataSourceConfig.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(userDataSourceConfig.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(userDataSourceConfig.getMaxIdleTime());
        xaDataSource.setTestQuery(userDataSourceConfig.getTestQuery());
        return xaDataSource;
    }

    @Bean(name = "UserSqlSessionFactory")
    public SqlSessionFactory UserSqlSessionFactory(@Qualifier("UserDataSource") DataSource dataSource)
            throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "UserSqlSessionTemplate")
    public SqlSessionTemplate UserSqlSessionTemplate(
            @Qualifier("UserSqlSessionFactory") SqlSessionFactory sqlSessionFactory)throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
