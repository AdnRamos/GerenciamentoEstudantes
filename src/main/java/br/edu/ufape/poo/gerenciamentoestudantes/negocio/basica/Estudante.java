package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estudante")
@PrimaryKeyJoinColumn
public class Estudante extends Usuario {

    //Duvidaa: é nescessario criar um id para as classes que herdam usuario?
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String matricula;
    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL)
    private List<Horario> horarios;
    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL)
    private List<RegistroAtividade> registros;
    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vinculo> vinculos;
    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL)
    private List<Funcao> funcoes;
    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL)
    private List<Participacao> participacoes;
    @ManyToOne
    private Orientador orientador;
    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL)
    private List<Inscricao> inscricao;


    public Estudante(boolean gestao, String nome, String email, String curso, String celular, String numeroRg, String orgaoExpedidor, String dataEmissao, String cpf, String estadoCivil, String nacionalidade, String naturalidade, String matricula) {
        super(gestao, nome, email, curso, celular, numeroRg, orgaoExpedidor, dataEmissao, cpf, estadoCivil, nacionalidade, naturalidade);
        this.matricula = matricula;
        this.matricula = matricula;
        this.horarios = new ArrayList<>();
        this.registros = new ArrayList<>();
        this.vinculos = new ArrayList<>();
        this.funcoes = new ArrayList<>();
        this.participacoes = new ArrayList<>();
        this.inscricao = new ArrayList<>();
    }

    public Estudante(boolean gestao, String nome, String email, String matricula) {
        super(gestao, nome, email);
        this.matricula = matricula;
        this.horarios = new ArrayList<>();
        this.registros = new ArrayList<>();
        this.vinculos = new ArrayList<>();
        this.funcoes = new ArrayList<>();
        this.participacoes = new ArrayList<>();
        this.inscricao = new ArrayList<>();
    }

    public Estudante(String matricula) {
        this.matricula = matricula;
        this.matricula = matricula;
        this.horarios = new ArrayList<>();
        this.registros = new ArrayList<>();
        this.vinculos = new ArrayList<>();
        this.funcoes = new ArrayList<>();
        this.participacoes = new ArrayList<>();
        this.inscricao = new ArrayList<>();
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

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;


    }
    public void addHorario(Horario horario){
        this.horarios.add(horario);
        horario.setEstudante(this);
    }

    public List<RegistroAtividade> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroAtividade> registros) {
        this.registros = registros;
    }
    public void addRegistro(RegistroAtividade registro){
        this.registros.add(registro);
        registro.setEstudante(this);
    }

    public List<Vinculo> getVinculos() {
        return vinculos;
    }

    public void setVinculos(List<Vinculo> vinculos) {
        this.vinculos = vinculos;
    }
    public void addVinculo(Vinculo vinculo){
        this.vinculos.add(vinculo);
        vinculo.setEstudante(this);
    }

    public List<Funcao> getFuncoes() {
        return funcoes;
    }

    public void setFuncoes(List<Funcao> funcoes) {
        this.funcoes = funcoes;
    }
    public void addFuncao(Funcao funcao){
        this.funcoes.add(funcao);
        funcao.setEstudante(this);
    }

    public List<Participacao> getParticipacoes() {
        return participacoes;
    }

    public void setParticipacoes(List<Participacao> participacoes) {
        this.participacoes = participacoes;
    }
    public void addParticipacao(Participacao participacao){
        this.setParticipacoes(participacoes);
        participacao.setEstudante(this);
    }

    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }

    public List<Inscricao> getInscricao() {
        return inscricao;
    }

    public void setInscricao(List<Inscricao> inscricao) {
        this.inscricao = inscricao;
    }

}