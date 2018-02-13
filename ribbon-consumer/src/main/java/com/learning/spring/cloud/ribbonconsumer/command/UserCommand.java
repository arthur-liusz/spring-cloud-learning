package com.learning.spring.cloud.ribbonconsumer.command;

import java.util.Objects;

import org.springframework.web.client.RestTemplate;

import com.learning.spring.cloud.ribbonconsumer.model.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixCommandProperties.ExecutionIsolationStrategy;
import com.netflix.hystrix.HystrixThreadPoolKey;

/**
 * <pre>
 * 通过“继承HystrixCommand类，并实现run()和getFallback()方法”的方式，使用HystrixCommand；
 * 这里的代码（这个类，这种方法），只是编写完成，尚未运行测试；
 * </pre>
 * 
 * @author arthur
 *
 */
public class UserCommand extends HystrixCommand<User> {

	private RestTemplate restTemplate;
	private Long id;

	protected UserCommand(com.netflix.hystrix.HystrixCommand.Setter setter, RestTemplate restTemplate, Long id) {
		super(Setter
				.withGroupKey(
						HystrixCommandGroupKey.Factory.asKey("GroupName-UserCommand"))
				.andCommandKey(
						HystrixCommandKey.Factory.asKey("CommandName-UserCommand"))
				.andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ThreadPoolName-UserCommand"))
				.andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withCircuitBreakerEnabled(true)
						.withCircuitBreakerForceClosed(false).withCircuitBreakerRequestVolumeThreshold(100)
						.withExecutionIsolationStrategy(ExecutionIsolationStrategy.THREAD)
						.withExecutionTimeoutInMilliseconds(1000).withExecutionTimeoutEnabled(true)
						.withExecutionIsolationThreadInterruptOnTimeout(true).withFallbackEnabled(true)
						.withFallbackIsolationSemaphoreMaxConcurrentRequests(10).withCircuitBreakerEnabled(true)
						.withCircuitBreakerRequestVolumeThreshold(20)
						.withMetricsRollingStatisticalWindowInMilliseconds(10000)
						.withMetricsRollingStatisticalWindowBuckets(1000).withRequestCacheEnabled(true)
						.withRequestLogEnabled(true)));
		this.restTemplate = restTemplate;
		this.id = id;
	}

	@Override
	protected User run() throws Exception {
		User user = this.restTemplate.getForObject("http://user-service/users/{1}", User.class, id);
		return user;
	}

	@Override
	protected User getFallback() {
		Throwable exception = this.getExecutionException();
		if (Objects.nonNull(exception) && exception instanceof RuntimeException) {
			System.out.println("111");
		} else {
			System.out.println("222");
		}

		User userFallback = new User();
		return userFallback;
	}

	@Override
	public String getCacheKey() {
		return String.valueOf(this.id);
	}
}