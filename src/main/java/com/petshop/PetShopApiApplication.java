package com.petshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.petshop")
//explicit scan of packages
public class PetShopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetShopApiApplication.class, args);
	}

}
