package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import jakarta.persistence.*;

@Entity
@Table(name = "inscricao")
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Bolsa bolsa;
    @ManyToOne
    private Estudante estudante;

    public Inscricao() {
    }

    public Inscricao(Bolsa bolsa, Estudante estudante) {
        this.bolsa = bolsa;
        this.estudante = estudante;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Bolsa getBolsa() {
        return bolsa;
    }

    public void setBolsa(Bolsa bolsa) {
        this.bolsa = bolsa;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
