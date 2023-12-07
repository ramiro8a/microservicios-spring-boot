package com.clients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ClientsManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientsManagerApplication.class, args);
	}

}
