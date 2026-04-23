package br.com.SistemaHospitalar.classes;

import java.time.LocalDateTime;

public class Internacao {
	
	private Integer id;
	private Paciente paciente;
	private Leito leito;
	private LocalDateTime data_entrada;
	private LocalDateTime data_saida;
	
	public Internacao(Integer id, Paciente paciente, Leito leito, LocalDateTime data_entrada,
			LocalDateTime data_saida) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.leito = leito;
		this.data_entrada = data_entrada;
		this.data_saida = data_saida;
	}

	public Integer getId() {
		return id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public Leito getLeito() {
		return leito;
	}

	public LocalDateTime getData_entrada() {
		return data_entrada;
	}

	public LocalDateTime getData_saida() {
		return data_saida;
	}

	@Override
	public String toString() {
		return "Internacao [id=" + id + ", paciente=" + paciente + ", leito=" + leito + ", data_entrada=" + data_entrada
				+ ", data_saida=" + data_saida + "]";
	}
	
	
	
}
