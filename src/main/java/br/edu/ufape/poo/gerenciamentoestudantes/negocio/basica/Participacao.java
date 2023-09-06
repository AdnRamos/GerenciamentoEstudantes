package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "participacao")
public class Participacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JsonIgnoreProperties({"participacoes", "inscricoes", "orientador", "vinculos", "registros", "login", "senha", "gestao","celular", "numeroRg", "orgaoExpedidor", "dataEmissao", "cpf", "estadoCivil", "nacionalidade", "naturalidade", "endereco", "curso", "funcao"})
    private Estudante estudante;
    @ManyToOne
    @JsonIgnoreProperties({"descricao", "dataCriacao", "dataCertificacao", "linguagensDeDesenvolvimento", "campoAplicacao", "tipoSistema", "participacoes", "scrumMaster", "orientador"})
    private Projeto projeto;
    private String dataInicio;
    private String dataFim;

    public Participacao() {
    }

    public Participacao(String dataInicio) {
        this.dataInicio = dataInicio;
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

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
}
