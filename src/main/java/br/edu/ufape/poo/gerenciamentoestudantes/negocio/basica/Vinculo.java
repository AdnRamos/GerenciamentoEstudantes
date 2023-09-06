package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.TipoVinculo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "vinculo")
public class Vinculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"participacoes", "inscricoes", "funcoes", "orientador", "vinculos", "registros", "login", "senha", "gestao", "email","celular", "numeroRg", "orgaoExpedidor", "dataEmissao", "cpf", "estadoCivil", "nacionalidade", "naturalidade", "endereco", "curso", "funcao"})
    private Estudante estudante;
    private boolean ativo;
    private TipoVinculo tipoVinculo;
    private String qtdHorasSemanais;
    private String dataInicio;
    private String dataFim;

    public Vinculo() {
    }

    public Vinculo(TipoVinculo tipoVinculo, String qtdHorasSemanais, String dataInicio) {
        this.tipoVinculo = tipoVinculo;
        this.qtdHorasSemanais = qtdHorasSemanais;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public TipoVinculo getTipoVinculo() {
        return tipoVinculo;
    }

    public void setTipoVinculo(TipoVinculo tipoVinculo) {
        this.tipoVinculo = tipoVinculo;
    }

    public String getQtdHorasSemanais() {
        return qtdHorasSemanais;
    }

    public void setQtdHorasSemanais(String qtdHorasSemanais) {
        this.qtdHorasSemanais = qtdHorasSemanais;
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
