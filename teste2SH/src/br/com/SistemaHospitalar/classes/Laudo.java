package br.com.SistemaHospitalar.classes;

public class Laudo {
	
	private Integer id;
	private Laboratorio laboratorio;
	private String arquivo_referencia;
	
	public Laudo(Integer id, Laboratorio laboratorio, String arquivo_referencia) {
		super();
		this.id = id;
		this.laboratorio = laboratorio;
		this.arquivo_referencia = arquivo_referencia;
	}

	public Integer getId() {
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
