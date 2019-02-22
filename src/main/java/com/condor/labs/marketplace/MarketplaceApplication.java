package com.condor.labs.marketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class MarketplaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketplaceApplication.class, args);
	}

}
