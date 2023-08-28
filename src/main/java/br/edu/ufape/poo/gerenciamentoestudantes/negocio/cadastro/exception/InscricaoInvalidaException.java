package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class InscricaoInvalidaException extends RuntimeException {

    public InscricaoInvalidaException() {
        super("Inscrição inválida");
    }

    public InscricaoInvalidaException(String message) {
        super(message);
    }

    public InscricaoInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }
}
