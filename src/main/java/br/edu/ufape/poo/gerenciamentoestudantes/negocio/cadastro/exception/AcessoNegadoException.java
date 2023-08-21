package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class AcessoNegadoException extends RuntimeException {
    public AcessoNegadoException() {
        super("Acesso negado: permissões insuficientes.");
    }

    public AcessoNegadoException(String mensagem) {
        super(mensagem);
    }
}