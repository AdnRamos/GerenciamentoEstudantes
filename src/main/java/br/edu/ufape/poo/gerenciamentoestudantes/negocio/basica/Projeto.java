package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "projeto")
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeProjeto;
    private String descricao;

    //private List<String> palavrasChaves;
    private String dataCricao;
    private String dataCertificacao;
    private String linguagensDeDesenvolvimento;
    private String campoDeAplicacao;
    private String tipoSistema;
    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    private List<Participacao> participacoes;
    @ManyToOne
    @JsonIgnoreProperties({"projetos", "orientandos","login", "senha", "gestao", "email","celular", "numeroRg", "orgaoExpedidor", "dataEmissao", "cpf", "estadoCivil", "nacionalidade", "naturalidade", "endereco","curso", "especialidade"})
    private Orientador orientador;
    @OneToOne
    @JsonIgnoreProperties({"participacoes", "inscricoes", "orientador", "vinculos", "registros", "login", "senha", "gestao", "email","celular", "numeroRg", "orgaoExpedidor", "dataEmissao", "cpf", "estadoCivil", "nacionalidade", "naturalidade", "endereco", "curso", "funcao","matricula"})
    private Estudante scrumMaster;

    public Projeto() {
    }

    public Projeto(String nomeProjeto, String descricao, String dataCricao, String linguagensDeDesenvolvimento, String campoDeAplicacao, String tipoSistema) {
        this.nomeProjeto = nomeProjeto;
        this.descricao = descricao;
        this.dataCricao = dataCricao;
        this.linguagensDeDesenvolvimento = linguagensDeDesenvolvimento;
        this.campoDeAplicacao = campoDeAplicacao;
        this.tipoSistema = tipoSistema;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataCricao() {
        return dataCricao;
    }

    public void setDataCricao(String dataCricao) {
        this.dataCricao = dataCricao;
    }

    public String getDataCertificacao() {
        return dataCertificacao;
    }

    public void setDataCertificacao(String dataCertificacao) {
        this.dataCertificacao = dataCertificacao;
    }

    public String getLinguagensDeDesenvolvimento() {
        return linguagensDeDesenvolvimento;
    }

    public void setLinguagensDeDesenvolvimento(String linguagensDeDesenvolvimento) {
        this.linguagensDeDesenvolvimento = linguagensDeDesenvolvimento;
    }

    public String getCampoDeAplicacao() {
        return campoDeAplicacao;
    }

    public void setCampoDeAplicacao(String compoDeAplicacao) {
        this.campoDeAplicacao = compoDeAplicacao;
    }

    public String getTipoSistema() {
        return tipoSistema;
    }

    public void setTipoSistema(String tipoSistema) {
        this.tipoSistema = tipoSistema;
    }


    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }

    public Estudante getScrumMaster() {
        return scrumMaster;
    }

    public void setScrumMaster(Estudante scrumMaster) {
        this.scrumMaster = scrumMaster;
    }

    public List<Participacao> getParticipacoes() {
        return participacoes;
    }

    public void setParticipacoes(List<Participacao> participacoes) {
        this.participacoes = participacoes;
    }
    public void addParcipacoes(Participacao participacao){
        this.setParticipacoes(participacoes);
    }
}
