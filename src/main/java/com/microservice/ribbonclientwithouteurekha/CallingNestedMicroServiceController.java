package com.microservice.ribbonclientwithouteurekha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CallingNestedMicroServiceController {
	
	@Autowired
	@Qualifier("loadBalanced")
	RestTemplate restTemplateLoad;
	
	@Autowired
	@Qualifier("nonLoadBalanced")
	RestTemplate restTemplate;

	@GetMapping("/")
	public String callingNestedServiceWithoutRibbon() {
		
		String name =restTemplate.getForObject("http://localhost:8892/name", String.class);
		return name;
		
	}
	
	@GetMapping("/ribbon")
	public String callingNestedServiceWithRibbon() {
		
		String name =restTemplateLoad.getForObject("http://nestedmicroservice/name", String.class);
		return name;
		
	}
}
