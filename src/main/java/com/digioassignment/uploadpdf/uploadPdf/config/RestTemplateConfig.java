package com.digioassignment.uploadpdf.uploadPdf.config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Component
@EnableScheduling
public class RestTemplateConfig {
	
	@Autowired
	CloseableHttpClient closableHttpClient;
	
	@Value("${digio.baseurl}")
	private String baseUrl;
	
	@Bean
	public RestTemplate restTemplate() {
	    RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
	    restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(baseUrl));
	    return restTemplate;
	}
	
	@Bean
	@ConditionalOnMissingBean
	public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {
	    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory 
	                        = new HttpComponentsClientHttpRequestFactory();
	    clientHttpRequestFactory.setHttpClient(closableHttpClient);
	    return clientHttpRequestFactory;
	}

}
