package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class FuncaoDuplicadaException extends RuntimeException {
    public FuncaoDuplicadaException(String mensagem) {
        super(mensagem);
    }
}