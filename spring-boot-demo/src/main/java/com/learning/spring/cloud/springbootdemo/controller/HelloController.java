package com.learning.spring.cloud.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello controller
 * 
 * @author arthur
 *
 */
@RestController
public class HelloController {
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	@Value("${person.name.fullName}")
	private String personFullName;

	@Value("${person.temporary.code}")
	private int personTemporaryCode;

	@RequestMapping("/index")
	public String index() {

		StringBuilder sb = new StringBuilder();
		sb.append("Hello world, this is the first spring-boot programe,").append(LINE_SEPARATOR);
		sb.append(" and your full name is : ").append(personFullName).append(",").append(LINE_SEPARATOR);
		sb.append(" and your temporary code is : ").append(personTemporaryCode).append(LINE_SEPARATOR);

		return sb.toString();
	}
}