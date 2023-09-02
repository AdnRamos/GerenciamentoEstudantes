package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "registroAtividade")
@EqualsAndHashCode(exclude = "estudante")
public class RegistroAtividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "estudante")
    private Estudante estudante;
    @OneToOne
    private Horario horario;
    private String descricao;

    public RegistroAtividade() {
    }

    public RegistroAtividade(String descricao) {
        super();
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
