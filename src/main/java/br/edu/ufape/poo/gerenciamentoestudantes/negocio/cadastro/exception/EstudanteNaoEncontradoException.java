package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class EstudanteNaoEncontradoException extends RuntimeException {

    public EstudanteNaoEncontradoException() {
        super("Estudante não encontrado");
    }

    public EstudanteNaoEncontradoException(String message) {
        super(message);
    }

    public EstudanteNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }
}