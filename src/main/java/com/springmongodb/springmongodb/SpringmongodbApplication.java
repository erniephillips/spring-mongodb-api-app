package com.springmongodb.springmongodb;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //https://www.geeksforgeeks.org/how-to-encrypt-passwords-in-a-spring-boot-project-using-jasypt/
@EnableEncryptableProperties
public class SpringmongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmongodbApplication.class, args);
	}

}
