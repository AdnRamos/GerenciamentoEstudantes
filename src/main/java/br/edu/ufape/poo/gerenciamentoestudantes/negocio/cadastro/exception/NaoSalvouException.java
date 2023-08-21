package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class NaoSalvouException extends RuntimeException{
    public NaoSalvouException(String mensagem) {
        super(mensagem);
    }

    public NaoSalvouException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
