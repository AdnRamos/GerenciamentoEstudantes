package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class DocumentoDuplicadoException extends RuntimeException {
    public DocumentoDuplicadoException(String nome) {
        super("Já existe um documento cadastrado com o nome: " + nome);
    }
}
