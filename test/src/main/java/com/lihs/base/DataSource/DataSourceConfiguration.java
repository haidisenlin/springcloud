package com.lihs.base.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author hsli
 * @Date 2018/6/25 9:45:42
 */
@Configuration
@RefreshScope
public class DataSourceConfiguration {

    @Resource
    private DataSourceProperties properties;

//    @Bean
//    public DataSource dataSource() {
//        DataSourceBuilder factory = DataSourceBuilder
//                .create(this.properties.getClassLoader())
//                .driverClassName(this.properties.getDriverClassName())
//                .url(this.properties.getUrl()).username(this.properties.getUsername())
//                .password(this.properties.getPassword());
//        if (this.properties.getType() != null) {
//            factory.type(this.properties.getType());
//        }
//        return factory.build();
//    }
    @Bean
    @RefreshScope
    @ConfigurationProperties(prefix = "spring.datasource") // application.properteis中对应属性的前缀
    public DataSource dataSource() {
//        DataSourceBuilder factory = DataSourceBuilder
//                .create(this.properties.getClassLoader())
//                .driverClassName(this.properties.getDriverClassName())
//                .url(this.properties.getUrl()).username(this.properties.getUsername())
//                .password(this.properties.getPassword());
//        if (this.properties.getType() != null) {
//            factory.type(this.properties.getType());
//        }
//        return factory.build();
        return DataSourceBuilder.create().build();
    }
}
