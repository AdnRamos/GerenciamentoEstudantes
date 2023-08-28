package br.edu.ufape.poo.gerenciamentoestudantes.dados;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Bolsa;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InterfaceColecaoInscricao extends JpaRepository<Inscricao, Long> {
    boolean existsByBolsaAndEstudante(Bolsa bolsa, Estudante estudante);

    Optional<Inscricao> findByEstudanteAndBolsa(Estudante estudante, Bolsa bolsa);

    List<Inscricao> findByEstudante(Estudante estudante);
}
