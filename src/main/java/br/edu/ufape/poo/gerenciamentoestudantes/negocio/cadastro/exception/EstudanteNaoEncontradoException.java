package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class EstudanteNaoEncontradoException extends RuntimeException {
    public EstudanteNaoEncontradoException(Long id) {
        super("Estudante com ID " + id + " não foi encontrado.");
    }
}