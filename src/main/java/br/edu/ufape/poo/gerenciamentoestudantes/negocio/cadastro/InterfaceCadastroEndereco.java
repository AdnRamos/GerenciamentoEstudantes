package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Endereco;

import java.util.List;
import java.util.Optional;

public interface InterfaceCadastroEndereco {
    List<Endereco> findAll();

    <S extends Endereco> S save(S entity);

    Optional<Endereco> findById(Long aLong);

    boolean existsById(Long aLong);

    void deleteById(Long aLong);

    void delete(Endereco entity);
}
