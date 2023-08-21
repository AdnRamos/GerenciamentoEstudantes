package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class VinculoNaoEncontradoException extends RuntimeException {

    private Long id;

    public VinculoNaoEncontradoException(Long id) {
        super("Vinculo não encontrado!");
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
