package com.learning.spring.cloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用来验证分布式配置中心配置项的Controller类
 * 
 * @author arthur
 *
 */
@RefreshScope
@RestController
public class TestController {

	@Value("${from}")
	private String from;

	@RequestMapping(value = "/fromhaha", method = RequestMethod.GET)
	public String from() {
		return "this is the from's value got from distributed-config-center:" + this.from;
	}
}