package br.com.SistemaHospitalar.classes;

public class Laudo {
	
	private Long id;
	private Laboratorio laboratorio;
	private String arquivo_referencia;
	
	public Laudo(Long id, Laboratorio laboratorio, String arquivo_referencia) {
		super();
		this.id = id;
		this.laboratorio = laboratorio;
		this.arquivo_referencia = arquivo_referencia;
	}

	public Long getId() {
		return id;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public String getArquivo_referencia() {
		return arquivo_referencia;
	}

	@Override
	public String toString() {
		return "Laudo [id=" + id + ", laboratorio=" + laboratorio + ", arquivo_referencia=" + arquivo_referencia + "]";
	}
	
}
