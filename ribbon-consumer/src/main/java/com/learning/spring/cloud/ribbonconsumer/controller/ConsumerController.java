package com.learning.spring.cloud.ribbonconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.spring.cloud.ribbonconsumer.service.HelloService;

/**
 * 服务消费者Controller类
 * 
 * @author arthur
 *
 */
@RestController
public class ConsumerController {

	@Autowired
	private HelloService helloService;

	@RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
	public String helloConsumer() {

		String responseBody = this.helloService.helloService();
		responseBody = "got data in ribbon-consumer by local-helloService from hello-service::" + responseBody;
		return responseBody;
	}
}