package com.desafiob2w.domains;

import java.util.List;

public class ResultApiSW {

	private List<PlanetaSWAPI> results;

	public ResultApiSW() {}
	
	public ResultApiSW(List<PlanetaSWAPI> results, String name) {
		this.results = results;
	}

	public List<PlanetaSWAPI> getResults() {
		return results;
	}
	
	
}
