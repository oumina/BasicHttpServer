package com.basic.http.web.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.basic.http.web.*")
public class BasicHttpWebServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicHttpWebServerApplication.class, args);
	}
}
