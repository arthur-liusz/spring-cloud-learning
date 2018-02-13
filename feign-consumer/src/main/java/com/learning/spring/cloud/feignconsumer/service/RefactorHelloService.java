package com.learning.spring.cloud.feignconsumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 服务消费方service接口实现层，通过继承公共的Service接口达到代码复用的目的
 * 
 * @author arthur
 *
 */
@FeignClient(value = "hello-service")
public interface RefactorHelloService extends com.learning.spring.cloud.helloserviceapi.service.HelloService {

}