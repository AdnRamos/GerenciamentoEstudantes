package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.TipoFuncao;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "funcao")
public class Funcao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Estudante estudante;
    private TipoFuncao tipoFuncao;
    private String dataInicio;
    private String dataFim;

    public Funcao() {
    }

    public Funcao(TipoFuncao tipoFuncao, String dataInicio) {
        this.tipoFuncao = tipoFuncao;
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

    public TipoFuncao getTipoFuncao() {
        return tipoFuncao;
    }

    public void setTipoFuncao(TipoFuncao tipoFuncao) {
        this.tipoFuncao = tipoFuncao;
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
