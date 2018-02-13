package com.learning.spring.cloud.ribbonconsumer.model;

/**
 * User对象类
 * 
 * @author arthur
 *
 */
public class User {
	private Long id;
	private int age;
	private String name;
	private String sex;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", age=" + age + ", name=" + name + ", sex=" + sex + "]";
	}
}