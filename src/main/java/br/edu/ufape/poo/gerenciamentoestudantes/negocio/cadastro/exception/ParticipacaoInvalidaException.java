package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Participacao;

public class ParticipacaoInvalidaException extends Throwable {
    public ParticipacaoInvalidaException() {
        super("Inscrição inválida");
    }

    public ParticipacaoInvalidaException(String message) {
        super(message);
    }


}
