package com.desafiob2w.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.desafiob2w.domains.Planeta;

@Repository
public interface PlanetaRepository extends MongoRepository<Planeta, String>{

	List<Planeta> findByNomeContainingIgnoreCase(String nome);
	
}
