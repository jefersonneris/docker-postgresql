package com.devneutro.dockerpostgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.devneutro.dockerpostgres")
@EnableJpaRepositories("com.devneutro.dockerpostgres")
public class DockerPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerPostgresApplication.class, args);
	}

}
