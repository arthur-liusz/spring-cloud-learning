package com.learning.spring.cloud.helloservice.controller;

import java.util.Random;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.spring.cloud.helloservice.model.User;

/**
 * hello controller
 * 
 * @author arthur
 *
 */
@RestController
public class HelloController {
	private final Logger logger = Logger.getLogger(HelloController.class.toString());

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		@SuppressWarnings("deprecation")
		ServiceInstance instance = client.getLocalServiceInstance();
		logger.info("hahaha:: /hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());

		try {
			Random random = new Random();
			int randomInt = random.nextInt(3000);
			logger.warning("HelloController.hello() will sleep in ms:" + randomInt);
			Thread.sleep(randomInt);
		} catch (InterruptedException e) {
			// ignore
		}

		return "Hello World, this is a message from HelloController.hello().";
	}

	// *********************以下是几个需要传参的方法********************* //

	@RequestMapping(value = "/hello1", method = RequestMethod.GET)
	public String hello(@RequestParam String name) {
		return "Hello, I am hello1, you are: " + name;
	}

	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	public User hello(@RequestHeader String name, @RequestHeader Integer age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		return user;
	}

	@RequestMapping(value = "/hello3", method = RequestMethod.POST)
	public String hello(@RequestBody User user) {
		return "Hello, I am hello3, you are: " + user.getName() + ", and you are " + user.getAge();
	}
}