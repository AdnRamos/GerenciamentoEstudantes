package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class DocumentoNaoDeletadoException extends RuntimeException {
    public DocumentoNaoDeletadoException(long id) {
        super("Não foi possível deletar o documento com ID: " + id);
    }
}