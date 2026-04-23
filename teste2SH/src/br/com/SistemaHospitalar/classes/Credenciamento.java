package br.com.SistemaHospitalar.classes;

import java.time.LocalDate;

public class Credenciamento {
	
	private Integer id;
	private Hospital hospital;
	private PlanoDeSaude planodeSaude;
	private LocalDate data_credenciamento;
	
	public Credenciamento(Integer id, Hospital hospital, PlanoDeSaude planodeSaude, LocalDate data_credenciamento) {
		super();
		this.id = id;
		this.hospital = hospital;
		this.planodeSaude = planodeSaude;
		this.data_credenciamento = data_credenciamento;
	}

	public Integer getId() {
		return id;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public PlanoDeSaude getPlanodeSaude() {
		return planodeSaude;
	}

	public LocalDate getData_credenciamento() {
		return data_credenciamento;
	}

	@Override
	public String toString() {
		return "Credenciamento [id=" + id + ", hospital=" + hospital + ", planodeSaude=" + planodeSaude
				+ ", data_credenciamento=" + data_credenciamento + "]";
	}
	
}
