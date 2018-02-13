package com.learning.spring.cloud.feignconsumer.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.spring.cloud.feignconsumer.model.User;
import com.learning.spring.cloud.feignconsumer.service.HelloService;
import com.learning.spring.cloud.feignconsumer.service.RefactorHelloService;

/**
 * 消费者本地向外提供访问功能的Controller类
 * 
 * @author arthur
 *
 */
@RestController
public class ConsumerController {
	private static final Logger logger = Logger.getLogger(ConsumerController.class);
	
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	@Autowired
	private HelloService helloService;

	@Autowired
	private RefactorHelloService refactorHelloService;

	@RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
	public String helloConsumer() {
		String rst = this.helloService.hello();

		logger.info("DATA got in Feign ConsumerController.helloConsumer() from remote: " + rst);

		return "DATA got in Feign ConsumerController.helloConsumer() from remote: " + rst;
	}

	@RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
	public String helloConsumer2() {
		User userParam = new User();
		userParam.setName("liushizhen");
		userParam.setAge(22222);

		StringBuilder sb = new StringBuilder();

		sb.append(this.helloService.hello("zhang san")).append("\n");
		sb.append(this.helloService.hello("li si", 33)).append("\n");
		sb.append(this.helloService.hello(userParam));

		return sb.toString();
	}

	@RequestMapping(value = "/feign-consumer3", method = RequestMethod.GET)
	public String helloConsumer3() {
		com.learning.spring.cloud.helloserviceapi.dto.User userParam = new com.learning.spring.cloud.helloserviceapi.dto.User();
		userParam.setName("hahaha");
		userParam.setAge(88);

		StringBuilder sb = new StringBuilder();

		sb.append(this.refactorHelloService.hello("arthur")).append(LINE_SEPARATOR);
		sb.append(this.refactorHelloService.hello("liushizhen", 35)).append(LINE_SEPARATOR);
		sb.append(this.refactorHelloService.hello(userParam)).append(LINE_SEPARATOR);

		return sb.toString();
	}
	
	@RequestMapping(value = "/feign-consumer4", method = RequestMethod.GET)
	public String helloConsumer4(){
		
		String result = this.helloService.hello();
		result = "Called via feign-consumer4::: " + result;
		
		return result;
	}
}