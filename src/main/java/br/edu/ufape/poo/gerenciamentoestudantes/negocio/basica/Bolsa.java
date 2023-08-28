package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "bolsa")
public class Bolsa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String descricao;
    private String edital;
    private String inicioInscricao;
    private String fimInscricao;
    @OneToMany(mappedBy = "bolsa", cascade = CascadeType.ALL)
    private List<Inscricao> inscricoes;

    public Bolsa() {
    }

    public Bolsa(String descricao, String edital, String inicioInscricao, String fimInscricao) {
        this.descricao = descricao;
        this.edital = edital;
        this.inicioInscricao = inicioInscricao;
        this.fimInscricao = fimInscricao;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEdital() {
        return edital;
    }

    public void setEdital(String edital) {
        this.edital = edital;
    }

    public String getInicioInscricao() {
        return inicioInscricao;
    }

    public void setInicioInscricao(String inicioInscricao) {
        this.inicioInscricao = inicioInscricao;
    }

    public String getFimInscricao() {
        return fimInscricao;
    }

    public void setFimInscricao(String fimInscricao) {
        this.fimInscricao = fimInscricao;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }
    public void addInscricao(Inscricao inscricao){
        this.inscricoes.add(inscricao);
        inscricao.setBolsa(this);
    }
}
