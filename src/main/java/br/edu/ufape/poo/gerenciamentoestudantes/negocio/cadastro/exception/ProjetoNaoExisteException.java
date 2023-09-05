package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class ProjetoNaoExisteException extends Exception {

    public ProjetoNaoExisteException(String nomeProjeto) {
        super("Projeto com nome '" + nomeProjeto + "' não encontrado.");
    }
    public ProjetoNaoExisteException(long id) {
        super("Projeto com nome '" + id + "' não encontrado.");
    }
}
