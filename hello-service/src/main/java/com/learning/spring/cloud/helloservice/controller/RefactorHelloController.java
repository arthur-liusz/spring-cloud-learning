package com.learning.spring.cloud.helloservice.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.spring.cloud.helloserviceapi.dto.User;
import com.learning.spring.cloud.helloserviceapi.service.HelloService;

/**
 * 在服务接口提供方，通过继承公共接口的方式，复用代码
 * 
 * @author arthur
 *
 */
@RestController
public class RefactorHelloController implements HelloService {

	@Override
	public String hello(@RequestParam("name") String name) {
		String result = "Hello, I am hello4, you are " + name;
		return result;
	}

	@Override
	public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		return user;
	}

	@Override
	public String hello(@RequestBody User user) {
		String result = "Hello, I am hello6, you are " + user.getName() + ", and your age is :" + user.getAge();
		return result;
	}
}