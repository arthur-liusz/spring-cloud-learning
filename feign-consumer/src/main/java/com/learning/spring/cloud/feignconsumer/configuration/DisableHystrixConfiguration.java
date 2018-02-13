package com.learning.spring.cloud.feignconsumer.configuration;

import feign.Feign;

/**
 * 关闭Hystrix的配置类
 * 
 * @author arthur
 *
 */
// 重要：如果这里使用了@Configuration，即使别处不引用，但是也会被spring扫描并加载进IOC容器，从而造成接下来的服务降级试验失败
// @Configuration
public class DisableHystrixConfiguration {

	// @Bean
	// @Scope("prototype")
	public Feign.Builder feignBuilder() {
		return Feign.builder();
	}
}