package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Horario;

public class HorarioConflitoException extends Exception {
    private Long id;
    private Horario horarioEmConflito;

    public HorarioConflitoException(Long id, Horario horarioEmConflito) {
        super("Horário com ID " + id + " entra em conflito com o horário: " + horarioEmConflito);
        this.id = id;
        this.horarioEmConflito = horarioEmConflito;
    }

    public Long getId() {
        return id;
    }

    public Horario getHorarioEmConflito() {
        return horarioEmConflito;
    }
}