package com.learning.spring.cloud.ribbonconsumer.service;

import java.util.List;

import com.learning.spring.cloud.ribbonconsumer.model.User;

/**
 * 用户接口
 * 
 * @author arthur
 *
 */
public interface UserService {

	/**
	 * 通过主键获取单个User对象
	 * 
	 * @param id
	 * @return
	 */
	public User find(Long id);

	/**
	 * 根据多个主键批量获取多个User对象
	 * 
	 * @param ids
	 * @return
	 */
	public List<User> findAll(List<Long> ids);
}