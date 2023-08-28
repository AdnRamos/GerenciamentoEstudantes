package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class ProjetoDuplicadoException extends Exception {

    public ProjetoDuplicadoException(String nomeProjeto) {
        super("Projeto com nome '" + nomeProjeto + "' já existe.");
    }
}
