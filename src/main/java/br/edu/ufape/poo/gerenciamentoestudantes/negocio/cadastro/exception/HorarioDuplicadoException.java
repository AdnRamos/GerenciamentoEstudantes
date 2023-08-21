package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.DiaSemana;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.ModalidadeAtividade;

public class HorarioDuplicadoException extends Exception{
    private Long id;



    public HorarioDuplicadoException(Long id){
        super("Horario duplicado.");
        this.id = id;


    }
    public Long getId() {
        return id;
    }
}
