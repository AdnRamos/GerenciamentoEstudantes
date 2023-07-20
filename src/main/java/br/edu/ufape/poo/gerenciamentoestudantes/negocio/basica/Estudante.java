package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estudante")
public class Estudante extends Usuario {
    private String matricula;
    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL)
    private List<Horario> horarios;
    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL)
    private List<RegistroAtividade> registros;


    public Estudante(boolean gestao, String nome, String email, String curso, String celular, String numeroRg, String orgaoExpedidor, String dataEmissao, String cpf, String estadoCivil, String nacionalidade, String naturalidade, String matricula) {
        super(gestao, nome, email, curso, celular, numeroRg, orgaoExpedidor, dataEmissao, cpf, estadoCivil, nacionalidade, naturalidade);
        this.matricula = matricula;

    }

    public Estudante(boolean gestao, String nome, String email, String matricula) {
        super(gestao, nome, email);
        this.matricula = matricula;


    }

    public Estudante(String matricula) {
        this.matricula = matricula;

    }
    public Estudante() {

    }
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<Horario> horarios) {
        this.horarios = horarios;


    }
    public void addHorario(Horario horario){
        this.horarios.add(horario);
        horario.setEstudante(this);
    }

    public List<RegistroAtividade> getRegistros() {
        return registros;
    }

    public void setRegistros(ArrayList<RegistroAtividade> registros) {
        this.registros = registros;
    }
    public void addRegistro(RegistroAtividade registro){
        this.registros.add(registro);
        registro.setEstudante(this);
    }
}