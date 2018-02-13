package com.learning.spring.cloud.feignconsumer.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.spring.cloud.feignconsumer.model.User;

/**
 * 服务接口Helloservice的服务降级逻辑实现类
 * 
 * @author arthur
 *
 */
@Component
public class HelloServiceFallback implements HelloService {

	@Override
	public String hello() {
		return "Error fallback, null-null-000";
	}

	@Override
	public String hello(@RequestParam("name") String name) {
		return "Error fallback, name==" + name;
	}

	@Override
	public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
		User user = new User();
		user.setName("Error fallback, " + name);
		user.setAge(age * 1000);
		return user;
	}

	@Override
	public String hello(User user) {
		return "Error fallback, hahahaha==" + user.getName() + ", " + user.getAge();
	}
}