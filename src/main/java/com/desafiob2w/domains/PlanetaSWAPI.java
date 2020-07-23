package com.desafiob2w.domains;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetaSWAPI {

	private String name;
	private List<String> films;
	
	public PlanetaSWAPI () {}
	
	public PlanetaSWAPI(String name, List<String> films) {
		super();
		this.setName(name);
		this.films = films;
	}

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
