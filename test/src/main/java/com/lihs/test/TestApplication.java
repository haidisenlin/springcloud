package com.lihs.test;

import javafx.application.Application;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableSwagger2
@EnableEurekaClient
@MapperScan(basePackages = {"com.lihs.dao"})
@ComponentScan(basePackages = {"com.lihs.**"})
@ImportResource(locations = { "classpath:druid-bean.xml" })
@EnableConfigurationProperties
public class TestApplication {

 	public static ApplicationContext context;


	public static void main(String[] args) {
		TestApplication.context =  SpringApplication.run(TestApplication.class, args);

	}
}
