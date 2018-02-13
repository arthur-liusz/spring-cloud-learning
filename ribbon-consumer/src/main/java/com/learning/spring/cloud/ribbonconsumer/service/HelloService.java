package com.learning.spring.cloud.ribbonconsumer.service;

/**
 * ribbon-consumer本地服务接口
 * 
 * @author arthur
 *
 */
public interface HelloService {
	/**
	 * 本地接口方法
	 * 
	 * @return
	 */
	public String helloService();
}