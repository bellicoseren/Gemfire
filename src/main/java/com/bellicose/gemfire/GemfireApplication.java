package com.bellicose.gemfire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import com.bellicose.gemfire.model.Automovil;
import com.bellicose.gemfire.repository.Repository;

@EnableGemfireRepositories
@SpringBootApplication
public class GemfireApplication implements CommandLineRunner{

	@Autowired
    Repository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(GemfireApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Automovil auto = new Automovil("Bugatti");

		System.out.println("Agregar auto: " + auto);
		repository.save(auto);
		
		
		System.out.println("Recuparando de Gemfire");
		Automovil auto2 = repository.findByAutomovil("Bugatti");
		System.out.println(auto2.toString());
		
	}
}
