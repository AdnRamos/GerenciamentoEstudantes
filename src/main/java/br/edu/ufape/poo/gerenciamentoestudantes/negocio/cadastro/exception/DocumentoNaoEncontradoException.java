package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class DocumentoNaoEncontradoException extends RuntimeException {
    public DocumentoNaoEncontradoException(long id) {
        super("Documento não encontrado com ID: " + id);
    }
}
