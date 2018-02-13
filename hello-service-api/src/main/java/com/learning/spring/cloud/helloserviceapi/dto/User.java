package com.learning.spring.cloud.helloserviceapi.dto;

/**
 * 公共的User对象，在服务提供方和服务消费方都需要使用到的
 * 
 * @author arthur
 *
 */
public class User {
	private String name;
	private Integer age;

	public User() {
		// default constructor
	}

	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
}