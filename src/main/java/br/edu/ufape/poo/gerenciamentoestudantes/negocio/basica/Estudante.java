package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import jakarta.persistence.*;

@Entity
//@Table(name = "estudante")
public class Estudante extends Usuario {
    private String matricula;


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

}