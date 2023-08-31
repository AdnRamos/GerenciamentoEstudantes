package br.edu.ufape.poo.gerenciamentoestudantes.dados;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceColecaoEstudante extends JpaRepository<Estudante, Long> {
    public Estudante findByEmail(String email);
    public Estudante findByNome(String nome);

    Estudante findByMatricula(String matricula);
}
