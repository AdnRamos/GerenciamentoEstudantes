package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class BolsaDuplicadaException extends RuntimeException {
    public BolsaDuplicadaException(String mensagem) {
        super(mensagem);
    }
}
