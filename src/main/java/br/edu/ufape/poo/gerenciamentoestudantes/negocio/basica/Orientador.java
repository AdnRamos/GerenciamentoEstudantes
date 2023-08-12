package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orientador")
public class Orientador extends Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String especialidade;
    @OneToMany(mappedBy = "orientador", cascade = CascadeType.ALL )
    private List<Projeto> projetos;

    @OneToMany(mappedBy = "orientador", cascade = CascadeType.ALL)
    private List<Estudante> orientandos;

    public Orientador(){

    }
    public Orientador(String especialidade) {
        this.especialidade = especialidade;
    }
    public Orientador(boolean gestao, String nome, String email, String curso, String celular, String numeroRg, String orgaoExpedidor, String dataEmissao, String cpf, String estadoCivil, String nacionalidade, String naturalidade, String especialidade) {
        super(gestao, nome, email, curso, celular, numeroRg, orgaoExpedidor, dataEmissao, cpf, estadoCivil, nacionalidade, naturalidade);
        this.especialidade = especialidade;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public List<Estudante> getOrientandos() {
        return orientandos;
    }

    public void setOrientandos(List<Estudante> orientandos) {
        this.orientandos = orientandos;
    }
}
