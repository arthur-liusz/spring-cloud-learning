package com.learning.spring.cloud.helloserviceapi.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.spring.cloud.helloserviceapi.dto.User;

/**
 * 公共的HelloService接口，在服务提供方和服务消费方都需要用到的
 * 
 * @author arthur
 *
 */
@RequestMapping("/refactor")
public interface HelloService {

	@RequestMapping(value = "/hello4", method = RequestMethod.GET)
	public String hello(@RequestParam("name") String name);

	@RequestMapping(value = "/hello5", method = RequestMethod.GET)
	public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

	@RequestMapping(value = "/hello6", method = RequestMethod.POST)
	public String hello(@RequestBody User user);
}