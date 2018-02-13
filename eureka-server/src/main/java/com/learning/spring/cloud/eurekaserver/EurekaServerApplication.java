package com.learning.spring.cloud.eurekaserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * spring-cloud-eureka-server，服务注册中心，应用程序主类
 * 
 * 备忘：“EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN
 * THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE
 * NOT BEING EXPIRED JUST TO BE
 * SAFE.”：在eureka浏览器控制台首页出现这个红色报警时，说明eureka已经进入了“保护模式”
 * 
 * <pre>
 * 可以通过如下方式，分别使用不同的配置文件启动多个实例：
 * 1.java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1
 * 2.java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2
 * 3.java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer3
 * </pre>
 * 
 * @author arthur
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaServerApplication.class).web(true).run(args);
		// SpringApplication.run(EurekaServerApplication.class, args);
	}
}