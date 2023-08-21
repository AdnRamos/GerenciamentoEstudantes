package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class RegistroAtividadeNaoEncontradoException extends RuntimeException {
    public RegistroAtividadeNaoEncontradoException(long id) {
        super("Registro de atividade não encontrado com ID: " + id);
    }
}