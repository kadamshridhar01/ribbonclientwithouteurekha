package com.microservice.ribbonclientwithouteurekha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RibbonClient(name = "nestedmicroservice", configuration = ConfigurationRibbon.class)
public class RibbonclientwithouteurekhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonclientwithouteurekhaApplication.class, args);
	}
	
	@Bean("nonLoadBalanced")
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean("loadBalanced")
	@LoadBalanced
	RestTemplate restTemplateLoad() {
		return new RestTemplate();
	}
}

