package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import jakarta.persistence.*;

@Entity
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "estudante")
    private Estudante estudante;
    @OneToOne
    private RegistroAtividade registro;
    private ModalidadeAtividade mdodalidade;
    private DiaSemana dia;
    private String horaInicio;
    private String horaFim;

    public Horario() {
    }

    public Horario(ModalidadeAtividade modalidade, DiaSemana dia, String horaInicio, String horaFim) {
        super();
        this.mdodalidade = modalidade;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
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

    public RegistroAtividade getRegistro() {
        return registro;
    }

    public void setRegistro(RegistroAtividade registro) {
        this.registro = registro;
    }

    public ModalidadeAtividade getMdodalidade() {
        return mdodalidade;
    }

    public void setMdodalidade(ModalidadeAtividade mdodalidade) {
        this.mdodalidade = mdodalidade;
    }

    public DiaSemana getDia() {
        return dia;
    }

    public void setDia(DiaSemana dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

}
