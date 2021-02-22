package com.example.mall.user.config;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 *@author dingrui
 *@date 2021-02-22
 *@description HikariConfig
 */
@Configuration
public class HikariConfig {

    @Value(value = "${spring.datasource.hikari.minimumIdle}")
    private int minIdle;

    @Value(value = "${spring.datasource.hikari.maximumPoolSize}")
    private int maxPoolSize;

    @Value(value = "${spring.datasource.hikari.idleTimeout}")
    private int idleTimeout;

    @Value(value = "${spring.datasource.hikari.maxLifetime}")
    private int maxLifetime;

    @Value(value = "${spring.datasource.hikari.connectionTimeout}")
    private int connectionTimeout;

    private HikariDataSource dataSource(HikariDataSource dataSource) {
        //连接超时时间设置
        dataSource.setConnectionTimeout(connectionTimeout);
        //连接空闲生命周期设置
        dataSource.setIdleTimeout(idleTimeout);
        //连接池允许的最大连接数量
        dataSource.setMaximumPoolSize(maxPoolSize);
        //检查空余连接优化连接池设置时间,单位毫秒
        dataSource.setMaxLifetime(maxLifetime);
        //连接池保持最小空余连接数量
        dataSource.setMinimumIdle(minIdle);
        return dataSource;
    }

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = DataSourceBuilder.create().type(HikariDataSource.class).build();
        return dataSource(dataSource);
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
