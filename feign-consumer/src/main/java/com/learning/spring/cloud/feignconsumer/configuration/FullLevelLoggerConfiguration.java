package com.learning.spring.cloud.feignconsumer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

/**
 * 日志级别配置类
 * 
 * @author arthur
 *
 */
@Configuration
public class FullLevelLoggerConfiguration {

	@Bean
	public Logger.Level feignLoggerLevel(){
		return Logger.Level.NONE;
	}
}