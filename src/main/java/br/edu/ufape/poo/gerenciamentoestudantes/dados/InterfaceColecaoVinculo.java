package br.edu.ufape.poo.gerenciamentoestudantes.dados;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Vinculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterfaceColecaoVinculo extends JpaRepository<Vinculo, Long> {
    List<Vinculo> findByEstudante(Estudante estudante);
}
