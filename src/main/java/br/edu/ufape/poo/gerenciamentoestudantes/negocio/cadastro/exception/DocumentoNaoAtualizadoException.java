package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class DocumentoNaoAtualizadoException extends RuntimeException {
    public DocumentoNaoAtualizadoException(long id) {
        super("Não foi possível atualizar o documento com ID: " + id);
    }

    public DocumentoNaoAtualizadoException(String mensagemErro, Exception e) {
    }
}