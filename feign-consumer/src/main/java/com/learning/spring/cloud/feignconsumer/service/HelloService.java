package com.learning.spring.cloud.feignconsumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.spring.cloud.feignconsumer.model.User;

/**
 * 消费者本地service接口
 * 
 * @author arthur
 *
 */
@FeignClient(name = "hello-service", fallback = HelloServiceFallback.class)
// @FeignClient(name = "hello-service", configuration =
// {DisableHystrixConfiguration.class})
public interface HelloService {

	@RequestMapping("/hello")
	public String hello();

	@RequestMapping(value = "/hello1", method = RequestMethod.GET)
	public String hello(@RequestParam("name") String name);

	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

	@RequestMapping(value = "/hello3", method = RequestMethod.POST)
	public String hello(@RequestBody User user);
}