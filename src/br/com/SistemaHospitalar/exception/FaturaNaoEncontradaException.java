package br.com.SistemaHospitalar.exception;

public class FaturaNaoEncontradaException extends Exception {
    
    public FaturaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}