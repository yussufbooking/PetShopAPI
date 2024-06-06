package com.petshop.PetShopAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.petshop.PetShopAPI")
//explicit scan of packages
public class PetShopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetShopApiApplication.class, args);
	}

}
