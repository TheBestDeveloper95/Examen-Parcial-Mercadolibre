package com.meli.mutant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MutantApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutantApplication.class, args);
		System.out.println("-----------");
		System.out.println("funcionando");
		System.out.println("-----------");
	}

}
