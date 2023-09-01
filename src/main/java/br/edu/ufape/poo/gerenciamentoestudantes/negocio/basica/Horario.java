package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.DiaSemana;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.ModalidadeAtividade;
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
    private ModalidadeAtividade modalidade;
    private DiaSemana diaSemana;
    private String horaInicio;
    private String horaFim;

    public Horario() {
    }

    public Horario(ModalidadeAtividade modalidade, DiaSemana diaSemana, String horaInicio, String horaFim) {
        super();
        this.modalidade = modalidade;
        this.diaSemana = diaSemana;
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
        registro.setHorario(this);
    }

    public ModalidadeAtividade getModalidade() {
        return modalidade;
    }

    public void setModalidade(ModalidadeAtividade mdodalidade) {
        this.modalidade = mdodalidade;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana dia) {
        this.diaSemana = dia;
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
