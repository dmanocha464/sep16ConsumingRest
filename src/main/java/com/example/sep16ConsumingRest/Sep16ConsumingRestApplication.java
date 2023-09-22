package com.example.sep16ConsumingRest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Sep16ConsumingRestApplication {

	private static final Logger log = LoggerFactory.getLogger(Sep16ConsumingRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Sep16ConsumingRestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Products product1 = restTemplate.getForObject(
					"https://fakestoreapi.com/products/1", Products.class);
			log.info(product1.toString());
			Products product2 = restTemplate.getForObject(
					"https://fakestoreapi.com/products/2", Products.class);
			log.info(product2.toString());
		};
	}
}
