package com.learning.spring.cloud.apigateway.filters;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 抛出异常的过滤器
 * 
 * @author arthur
 *
 */
@Component
public class ThrowExceptionFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		try {
			this.doSomething();
		} catch (Exception e) {
			ZuulException ze = new ZuulException(e, 0, null);
			ctx.setThrowable(ze);
			throw new ZuulRuntimeException(e);
		}

		return null;
	}

	private void doSomething() {
		throw new RuntimeException();
	}
}