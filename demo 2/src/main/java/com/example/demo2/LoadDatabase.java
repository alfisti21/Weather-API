package com.example.demo2;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(TemperaturesRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Temperatures(-10, 0, "Russian Coat")));
			log.info("Preloading " + repository.save(new Temperatures(1, 10, "US Parka")));
			log.info("Preloading " + repository.save(new Temperatures(11, 20, "Regular Jacket")));
			log.info("Preloading " + repository.save(new Temperatures(21, 30, "T-shirt and Flip-Flops")));
			log.info("Preloading " + repository.save(new Temperatures(31, 40, "Swimming Costume")));
		};
	}
}