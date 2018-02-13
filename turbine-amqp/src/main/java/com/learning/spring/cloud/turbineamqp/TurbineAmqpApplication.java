package com.learning.spring.cloud.turbineamqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * 通过RabbitMQ实现Turbine聚合监控，程序主类
 * 
 * @author arthur
 *
 */
@EnableTurbineStream
@EnableDiscoveryClient
@SpringBootApplication
public class TurbineAmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurbineAmqpApplication.class, args);
	}
}
