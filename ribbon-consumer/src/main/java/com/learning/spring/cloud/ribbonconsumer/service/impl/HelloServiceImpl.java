package com.learning.spring.cloud.ribbonconsumer.service.impl;

import java.nio.charset.UnsupportedCharsetException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learning.spring.cloud.ribbonconsumer.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * ribbon-consumer本地服务接口实现类
 * 
 * @author arthur
 *
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	@HystrixCommand(fallbackMethod = "helloFallback", groupKey = "GroupKey-HelloService", commandKey = "CommandKey-HelloService", threadPoolKey = "ThreadPoolKey-HelloService", ignoreExceptions = {
			UnsupportedCharsetException.class, NullPointerException.class }, commandProperties = {
					@HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
//					@HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"),
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000") }
//			, threadPoolProperties = {
//							@HystrixProperty(name = "coreSize", value = "20"),
//							@HystrixProperty(name = "maxQueueSize", value = "1000") }
	)
	public String helloService() {
		String responseBody = this.restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
		return responseBody;
	}

	public String helloFallback(Throwable exception) {
		if (Objects.nonNull(exception) && exception instanceof RuntimeException) {
			System.out.println("111");
		} else {
			System.out.println("222");
		}

		return "this is the ERROR from ribbon-consumer local helloFallback() method.";
	}
}