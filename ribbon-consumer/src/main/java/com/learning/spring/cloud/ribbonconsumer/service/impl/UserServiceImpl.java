package com.learning.spring.cloud.ribbonconsumer.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learning.spring.cloud.ribbonconsumer.model.User;
import com.learning.spring.cloud.ribbonconsumer.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * 用户接口实现类
 * 
 * @author arthur
 *
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

	private RestTemplate restTemplate;

	@Override
	@HystrixCollapser(batchMethod = "findAll", collapserProperties = {
			@HystrixProperty(name = "timerDelayInMilliseconds", value = "100"),
			@HystrixProperty(name = "maxRequestsInBatch", value = "100"),
			@HystrixProperty(name = "timerDelayInMilliseconds", value = "10"),
			@HystrixProperty(name = "requestCache.enabled", value = "true") })
	public User find(Long id) {
		return null;
	}

	@Override
	// @CacheResult(cacheKeyMethod = "")
	// @CacheRemove(cacheKeyMethod = "", commandKey = "")
	@HystrixCommand(fallbackMethod = "findAllFallback", groupKey = "UserServiceGroupName", commandKey = "UserServiceCommandName", threadPoolKey = "UserServiceThreadPoolName", commandProperties = {
			@HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"),
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
			@HystrixProperty(name = "execution.timeout.enabled", value = "true"),
			@HystrixProperty(name = "execution.isolation.thread.interruptOnTimeout", value = "true"),
			@HystrixProperty(name = "fallback.enabled", value = "true"),
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "10"),
			@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "20"),
			@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000"),
			@HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "1000"),
			@HystrixProperty(name = "requestCache.enabled", value = "true"),
			@HystrixProperty(name = "requestLog.enabled", value = "true") }, threadPoolProperties = {
					@HystrixProperty(name = "coreSize", value = "10"),
					@HystrixProperty(name = "maxQueueSize", value = "10000"),
					@HystrixProperty(name = "queueSizeRejectionThreshold", value = "5") })
	public List<User> findAll(/* @CacheKey long id */List<Long> ids) {
		this.restTemplate.getForObject("http://user-service/users/ids={1}", List.class, ids);
		return null;
	}

	public List<User> findAllFallback(Throwable exception) {

		return null;
	}
}