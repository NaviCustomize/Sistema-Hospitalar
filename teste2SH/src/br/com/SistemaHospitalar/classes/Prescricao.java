package br.com.SistemaHospitalar.classes;

public class Prescricao {
	
	private Integer id;
	private Atendimento atendimento;
	private Medicamento medicamento;
	private String observacao;
	
	public Prescricao(Integer id, Atendimento atendimento, Medicamento medicamento, String observacao) {
		super();
		this.id = id;
		this.atendimento = atendimento;
		this.medicamento = medicamento;
		this.observacao = observacao;
	}

	public Integer getId() {
		return id;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}
	
	public Medicamento getMedicamento() {
		return medicamento;
	}
	
	public String getObservacao() {
		return observacao;
	}

	@Override
	public String toString() {
		return "Prescricao [id=" + id + ", atendimento=" + atendimento + ", medicamento=" + medicamento
				+ ", observacao=" + observacao + "]";
	}
	
}
