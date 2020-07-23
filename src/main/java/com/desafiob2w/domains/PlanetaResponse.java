package com.desafiob2w.domains;

public class PlanetaResponse {

	private String id;
	private String nome;
	private String clima;
	private String terreno;
	private Integer quantidadeAparicao;
	
	public PlanetaResponse(String id, String nome, String clima, String terreno, Integer quantidadeAparicao) {
		super();
		this.id = id;
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
		this.quantidadeAparicao = quantidadeAparicao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Integer getQuantidadeAparicao() {
		return quantidadeAparicao;
	}

	public void setQuantidadeAparicao(Integer quantidadeAparicao) {
		this.quantidadeAparicao = quantidadeAparicao;
	}
	
	
	
}
