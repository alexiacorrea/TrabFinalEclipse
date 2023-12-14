package com.example.Trabalho;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Trabalho.entities.Tarefa;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

@SpringBootApplication
public class TrabalhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabalhoApplication.class, args);
	}
	
}
