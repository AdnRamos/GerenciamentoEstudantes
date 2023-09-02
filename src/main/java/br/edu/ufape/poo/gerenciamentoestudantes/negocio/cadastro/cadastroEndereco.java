package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoEndereco;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class cadastroEndereco implements InterfaceCadastroEndereco {
    @Autowired
    private InterfaceColecaoEndereco colecaoEndereco;

    @Override
    public List<Endereco> findAll() {
        return colecaoEndereco.findAll();
    }

    @Override
    public <S extends Endereco> S save(S entity) {
        return colecaoEndereco.save(entity);
    }

    @Override
    public Optional<Endereco> findById(Long aLong) {
        return colecaoEndereco.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return colecaoEndereco.existsById(aLong);
    }

    @Override
    public void deleteById(Long aLong) {
        colecaoEndereco.deleteById(aLong);
    }

    @Override
    public void delete(Endereco entity) {
        colecaoEndereco.delete(entity);
    }
}
