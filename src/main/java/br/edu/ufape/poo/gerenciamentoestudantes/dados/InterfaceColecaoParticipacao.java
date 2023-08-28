package br.edu.ufape.poo.gerenciamentoestudantes.dados;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Participacao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterfaceColecaoParticipacao extends JpaRepository<Participacao, Long> {
    boolean existsByEstudanteAndProjeto(Estudante estudante, Projeto projeto);

    List<Participacao> findByProjeto(Projeto projeto);

    List<Participacao> findByEstudante(Estudante estudante);
}
