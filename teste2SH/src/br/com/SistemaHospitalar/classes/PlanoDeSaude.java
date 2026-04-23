package br.com.SistemaHospitalar.classes;

import br.com.SistemaHospitalar.enums.Cobertura;

public class PlanoDeSaude {
	
	private Integer id;
	private String nome_convenio;
	private String telefone;
	private Cobertura cobertura;
	
	public PlanoDeSaude(Integer id, String nome_convenio, String telefone, Cobertura cobertura) {
		super();
		this.id = id;
		this.nome_convenio = nome_convenio;
		this.telefone = telefone;
		this.cobertura = cobertura;
	}

	public Integer getId() {
		return id;
	}

	public String getNome_convenio() {
		return nome_convenio;
	}

	public String getTelefone() {
		return telefone;
	}

	public Cobertura getCobertura() {
		return cobertura;
	}

	@Override
	public String toString() {
		return "PlanoDeSaude [id=" + id + ", nome_convenio=" + nome_convenio + ", telefone=" + telefone + ", cobertura="
				+ cobertura + "]";
	}
	
}	
