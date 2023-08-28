package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class FuncaoNaoEncontradaException extends RuntimeException {
    public FuncaoNaoEncontradaException(long id) {
        super("Função com ID " + id + " não encontrada");
    }
}
