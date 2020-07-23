package com.desafiob2w.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafiob2w.domains.Planeta;
import com.desafiob2w.domains.PlanetaResponse;
import com.desafiob2w.domains.PlanetaSWAPI;
import com.desafiob2w.services.PlanetaService;
import com.desafiob2w.util.URL;
import com.desafiob2w.ws.RestSWAP;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
public class PlanetaController {

	@Autowired
	private PlanetaService service;
	@Autowired
	private RestSWAP rest;

	private Calendar momento = Calendar.getInstance();
	private List<PlanetaSWAPI> result = new ArrayList<PlanetaSWAPI>();

	@ApiOperation("Inclui um planeta")
	@PostMapping("/planeta")
	public ResponseEntity<Void> incluiPlaneta(@RequestBody Planeta planeta) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(service.incluiPlaneta(planeta).getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation("Lista todos os planetas")
	@GetMapping("/planetas")
	public ResponseEntity<List<PlanetaResponse>> listaPlanetas(){
		return ResponseEntity.ok().body(incluiAparicao(service.listaPlanetas()));
	}

	@ApiOperation("Busca um planeta pelo ID")
	@GetMapping("/{id}")
	public ResponseEntity<PlanetaResponse> listaPlanetasPorId(@PathVariable("id") String id) {
		Planeta planeta = service.buscaPorId(id);
		this.result = ehCache(result, momento);
		return ResponseEntity.ok().body(new PlanetaResponse(planeta.getId(), planeta.getNome(), planeta.getClima(),
				planeta.getTerreno(), buscaAparicao(result, planeta)));
	}

	@ApiOperation("Planeta um planeta pelo nome")
	@GetMapping("/planeta/{nome}")
	public ResponseEntity<List<PlanetaResponse>> listaPlanetasPorNome(
			@RequestParam(value = "nome", defaultValue = "") String nome) {
		List<PlanetaResponse> planetas = new ArrayList<>();
		this.result = ehCache(this.result, momento);
		for (Planeta planeta : service.listaPorNome(URL.decode(nome))) {
			planetas.add(new PlanetaResponse(planeta.getId(), planeta.getNome(), planeta.getClima(),
					planeta.getTerreno(), buscaAparicao(result, planeta)));
		}
		return ResponseEntity.ok().body(planetas);
	}

	@ApiOperation("Exclui um planeta pelo ID")
	@DeleteMapping("/planeta/{id}")
	public ResponseEntity<Void> excluiPlaneta(@PathVariable String id) {
		this.service.excluiPlaneta(id);
		return ResponseEntity.noContent().build();
	}

	private List<PlanetaSWAPI> ehCache(List<PlanetaSWAPI> result, Calendar momento) {

		Calendar momentoAtual = Calendar.getInstance();
		Calendar momentoComparar = (Calendar) momento.clone();
		momentoComparar.add(Calendar.HOUR_OF_DAY, 1);
		if(result.isEmpty()) {
			result = rest.RetornaAparicoes().getBody().getResults();
		}
		if(momentoAtual.after(momentoComparar)) {
			result = rest.RetornaAparicoes().getBody().getResults(); 
			momento = Calendar.getInstance();
		}
		return result;
	}

	private Integer buscaAparicao(List<PlanetaSWAPI> result, Planeta planeta) {
		for (PlanetaSWAPI planetaSW : result) {
			if (planetaSW.getName().equals(planeta.getNome())) {
				return planetaSW.getFilms().size();
			}
		}
		return 0;
	}

	private List<PlanetaResponse> incluiAparicao(List<Planeta> planetas) {
		List<PlanetaResponse> listaPlaneta = new ArrayList<>();
		this.result = ehCache(this.result, momento);
		for (Planeta planeta : planetas) {
			listaPlaneta.add(new PlanetaResponse(planeta.getId(), planeta.getNome(), planeta.getClima(),
					planeta.getTerreno(), buscaAparicao(result, planeta)));
		}
		return listaPlaneta;

	}
}
