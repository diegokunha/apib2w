package com.desafiob2w.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiob2w.domains.Planeta;
import com.desafiob2w.exceptions.BadRequest;
import com.desafiob2w.exceptions.ObjectNotFoundException;
import com.desafiob2w.repositories.PlanetaRepository;

@Service
public class PlanetaService {

	@Autowired
	private PlanetaRepository repository;
	
	public Planeta incluiPlaneta(Planeta planeta) {
		verificaPlaneta(planeta);
		planeta.setId(null);
		return this.repository.save(planeta);
	}
	
	public List<Planeta> listaPlanetas(){
		return repository.findAll();
	}
	
	public Planeta buscaPorId(String id) {
		Optional<Planeta> planetaId = repository.findById(id);
		return planetaId.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado"));
	}

	public void excluiPlaneta(String id) {
		repository.deleteById(id);
	}

	public List<Planeta> listaPorNome(String nome) {
		return repository.findByNomeContainingIgnoreCase(nome);
	}
	
	public Planeta geraId(Planeta planeta) {
		Planeta id = repository.save(new Planeta());     
		planeta.setId(id.getId());
		return planeta;
	}

	
	private Planeta verificaPlaneta(Planeta planeta) {
		try {	
			if(planeta.getNome().equals(null) || planeta.getNome().isEmpty()) {
				throw new BadRequest("Campo nome vazio");
			}
			if(planeta.getClima().equals(null) || planeta.getClima().isEmpty()) {
				throw new BadRequest("Campo clima vazio");
			}
			if(planeta.getTerreno().equals(null) || planeta.getTerreno().isEmpty()) {
				throw new BadRequest("Campo terreno vazio");
			}
		}catch(Exception e) {
			
			throw new BadRequest("Erro ao inserir null");
		}
		return planeta;
		
	}
}
