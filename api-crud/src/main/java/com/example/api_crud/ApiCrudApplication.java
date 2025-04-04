package com.example.api_crud;

import org.springframework.boot.SpringApplication;  // Importa a classe que inicializa a aplicação Spring Boot
import org.springframework.boot.autoconfigure.SpringBootApplication;  // Importa a anotação para configurar a aplicação Spring Boot

// A anotação @SpringBootApplication marca esta classe como a classe principal de configuração da aplicação Spring Boot.
// Ela combina várias anotações essenciais, como @Configuration, @EnableAutoConfiguration e @ComponentScan.
@SpringBootApplication
public class ApiCrudApplication {

	// O método main é o ponto de entrada da aplicação. Ele é executado quando a aplicação é iniciada.
	public static void main(String[] args) {
		// Chama o método run da classe SpringApplication para inicializar o contexto Spring e iniciar a aplicação.
		SpringApplication.run(ApiCrudApplication.class, args);
	}
}
