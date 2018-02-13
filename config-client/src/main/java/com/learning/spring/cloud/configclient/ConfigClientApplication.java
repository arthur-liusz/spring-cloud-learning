package com.learning.spring.cloud.configclient;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 分布式配置中心，客户端项目，主程序类
 * 
 * @author arthur
 *
 */
@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {

		new SpringApplicationBuilder(ConfigClientApplication.class).web(true).run(args);
	}
}