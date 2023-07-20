package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enum.TipoVinculo;
import jakarta.persistence.*;

@Entity
@Table(name = "vinculo")
public class Vinculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Estudante estudante;

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

    public TipoVinculo getTipoVinculo() {
        return tipoVinculo;
    }

    public void setTipoVinculo(TipoVinculo tipoVinculo) {
        this.tipoVinculo = tipoVinculo;
    }

    public String getQtdHorasSemanais() {
        return qtdHorasSemanais;
    }

    public void getQtdHorasSemanais(String qtdHoras) {
        this.qtdHorasSemanais = qtdHoras;
    }

    public String setQtdHorasSemanais() {
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
