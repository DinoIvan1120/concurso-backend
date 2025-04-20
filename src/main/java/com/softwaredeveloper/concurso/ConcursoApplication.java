package com.softwaredeveloper.concurso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ConcursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcursoApplication.class, args);
	}

}
