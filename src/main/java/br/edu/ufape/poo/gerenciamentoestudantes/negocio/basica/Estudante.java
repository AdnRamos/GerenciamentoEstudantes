package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estudante")
public class Estudante extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String matricula;

    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RegistroAtividade> registros = new ArrayList<>();

    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vinculo> vinculos = new ArrayList<>();

    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Funcao> funcoes = new ArrayList<>();

    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Participacao> participacoes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Orientador orientador;

    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Inscricao> inscricoes = new ArrayList<>();

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
    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<RegistroAtividade> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroAtividade> registros) {
        this.registros = registros;
    }
    public void addRegistro(RegistroAtividade registro){
        this.registros.add(registro);
    }

    public List<Vinculo> getVinculos() {
        return vinculos;
    }

    public void setVinculos(List<Vinculo> vinculos) {
        this.vinculos = vinculos;
    }
    public void addVinculo(Vinculo vinculo){
        this.vinculos.add(vinculo);
    }

    public List<Funcao> getFuncoes() {
        return funcoes;
    }

    public void setFuncoes(List<Funcao> funcoes) {
        this.funcoes = funcoes;
    }
    public void addFuncao(Funcao funcao){
        this.funcoes.add(funcao);
    }

    public List<Participacao> getParticipacoes() {
        return participacoes;
    }

    public void setParticipacoes(List<Participacao> participacoes) {
        this.participacoes = participacoes;
    }
    public void addParticipacao(Participacao participacao){
        this.setParticipacoes(participacoes);
    }

    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricao) {
        this.inscricoes = inscricao;
    }
    public void addInscricao(Inscricao inscricao){
        this.inscricoes.add(inscricao);
    }

}