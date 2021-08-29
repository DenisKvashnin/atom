package ru.atom.hachaton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
@EnableFeignClients
@EnableJpaRepositories(basePackages = "ru.atom.hachaton.repository")
@EntityScan("ru.atom.hachaton.model.entity")
public class HackatonApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackatonApplication.class, args);
	}

}
