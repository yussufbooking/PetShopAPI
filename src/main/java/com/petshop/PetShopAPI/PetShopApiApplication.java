package com.petshop.PetShopAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class })
public class PetShopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetShopApiApplication.class, args);
	}

}
