package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class InscricaoDuplicadaException extends RuntimeException {

    public InscricaoDuplicadaException() {
        super("Inscrição duplicada");
    }

    public InscricaoDuplicadaException(String message) {
        super(message);
    }

    public InscricaoDuplicadaException(String message, Throwable cause) {
        super(message, cause);
    }
}