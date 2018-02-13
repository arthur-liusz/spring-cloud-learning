package com.learning.spring.cloud.helloservice.model;

public class User {
	private String name;
	private Integer age;

	public User() {
		// default constructor
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
}