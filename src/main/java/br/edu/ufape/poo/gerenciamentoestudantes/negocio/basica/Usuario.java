package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String login;
    private String senha;
    private boolean gestao;
    private String nome;
    private String email;
    private String curso;
    private String celular;
    private String numeroRg;
    private String orgaoExpedidor;
    private String dataEmissao;
    private String cpf;
    private String estadoCivil;
    private String nacionalidade;
    private String naturalidade;
    @OneToOne
    private Endereco endereco;

    public Usuario(boolean gestao, String nome, String email, String curso, String celular, String numeroRg, String orgaoExpedidor, String dataEmissao, String cpf, String estadoCivil, String nacionalidade, String naturalidade) {
        super();
        this.login = cpf;
        this.senha = cpf;
        this.gestao = gestao;
        this.nome = nome;
        this.email = email;
        this.curso = curso;
        this.celular = celular;
        this.numeroRg = numeroRg;
        this.orgaoExpedidor = orgaoExpedidor;
        this.dataEmissao = dataEmissao;
        this.cpf = cpf;
        this.estadoCivil = estadoCivil;
        this.nacionalidade = nacionalidade;
        this.naturalidade = naturalidade;
    }

    public Usuario(boolean gestao, String nome, String email) {
        super();
        this.gestao = gestao;
        this.nome = nome;
        this.email = email;
    }

    public Usuario() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isGestao() {
        return gestao;
    }

    public void setGestao(boolean gestao) {
        this.gestao = gestao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNumeroRg() {
        return numeroRg;
    }

    public void setNumeroRg(String numeroRg) {
        this.numeroRg = numeroRg;
    }

    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }

    public void setOrgaoExpedidor(String orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
