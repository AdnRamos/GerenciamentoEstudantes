package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class DocumentoInvalidoException extends Exception {
    public DocumentoInvalidoException(String mensagem, Exception e) {
        super(mensagem);
    }
}