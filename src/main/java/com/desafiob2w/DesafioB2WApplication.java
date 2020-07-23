package com.desafiob2w;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.desafiob2w.domains.Planeta;
import com.desafiob2w.repositories.PlanetaRepository;

import lombok.extern.log4j.Log4j2;


@Log4j2
@SpringBootApplication
public class DesafioB2WApplication implements CommandLineRunner{

	@Autowired
	private PlanetaRepository planetrepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioB2WApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Planeta planeta;
		if(planetrepo.count() == 0) {
			planeta = planetrepo.save(new Planeta());
			planetrepo.deleteById(planeta.getId());
		}
	
	}

}
