package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class BolsaNaoEncontradaException extends RuntimeException {
    public BolsaNaoEncontradaException(String message) {
        super(message);
    }
}