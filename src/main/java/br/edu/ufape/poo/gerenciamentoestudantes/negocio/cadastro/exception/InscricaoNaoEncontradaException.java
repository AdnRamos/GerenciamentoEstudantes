package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class InscricaoNaoEncontradaException extends RuntimeException {

    public InscricaoNaoEncontradaException() {
        super("Inscrição não encontrada");
    }

    public InscricaoNaoEncontradaException(String message) {
        super(message);
    }

    public InscricaoNaoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }
}
