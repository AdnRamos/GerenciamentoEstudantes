package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

public class HorarioExisteException extends Exception{
    private Long id;


    public HorarioExisteException(Long id){
        super("Horario não cadastrado.");
        this.id = id;
    }
    public Long getId(){
        return id;
    }
}
