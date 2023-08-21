package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class HorarioNaoEncontradoException extends Exception {
    private Long id;

    public HorarioNaoEncontradoException(Long id) {
        super("Horário com ID " + id + " não foi encontrado");
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
