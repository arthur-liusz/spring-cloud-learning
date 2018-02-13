package com.learning.spring.cloud.apigateway.filters;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 过滤器，用于校验请求中是否有‘accessToken’参数
 * 
 * @author arthur
 *
 */
public class AccessFilter extends ZuulFilter {
	private static final Logger logger = Logger.getLogger(AccessFilter.class);

	@Override
	public String filterType() {
		return "pre";
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
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		String accessToken = request.getParameter("accessToken");

		if (StringUtils.isBlank(accessToken)) {
			logger.error("required accessToken is EMPTY, take you back!");
			requestContext.setSendZuulResponse(false);
			requestContext.setResponseStatusCode(401);
		} else {
			logger.info("required accessToken is OK, let you go!");
		}

		return null;
	}
}