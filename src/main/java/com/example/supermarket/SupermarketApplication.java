package com.example.supermarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;;

// @ComponentScan(basePackages = {"com.billingsystem.repository", "com.billingsystem.service", "com.billingsystem.controller"})
@ComponentScan(basePackages = {"com.example.supermarket.repository", "com.example.supermarket.service", "com.example.supermarket.controller"})
// @EnableJpaRepositories(basePackages = {"com.billingsystem.repository"})
@EnableJpaRepositories(basePackages = {"com.example.supermarket.repository"})


@SpringBootApplication
@EnableJpaAuditing
@EnableTransactionManagement
@EnableCaching
@EntityScan(basePackages = { "com.example.supermarket.model" })
@EnableAutoConfiguration
@ComponentScan("com.example.supermarket.controller")
@ComponentScan("com.example.supermarket.repository")
// @SpringBootApplication
public class SupermarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupermarketApplication.class, args);
	}

}
