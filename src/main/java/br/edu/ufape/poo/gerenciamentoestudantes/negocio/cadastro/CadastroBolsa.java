package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoBolsa;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Bolsa;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.BolsaDuplicadaException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.BolsaNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroBolsa implements InterfaceCadastroBolsa {
    @Autowired
    private InterfaceColecaoBolsa cadastroBolsa;

    @Override
    public Bolsa cadastrarBolsa(Bolsa bolsa) throws BolsaDuplicadaException {
        if (cadastroBolsa.existsByDescricao(bolsa.getDescricao())) {
            throw new BolsaDuplicadaException("Bolsa já cadastrada com a mesma descrição.");
        }
        return cadastroBolsa.save(bolsa);
    }

    @Override
    public Bolsa buscarBolsaPorId(long id) {
        return cadastroBolsa.findById(id).orElseThrow(() ->
                new BolsaNaoEncontradaException("Bolsa não encontrada com o ID: " + id));
    }

    @Override
    public List<Bolsa> listarBolsas() {
        return cadastroBolsa.findAll();
    }

    @Override
    public Bolsa atualizarBolsa(Bolsa bolsa) {
        return cadastroBolsa.save(bolsa);
    }

    @Override
    public void deletarBolsa(long id) {
        if (!cadastroBolsa.existsById(id)) {
            throw new BolsaNaoEncontradaException("Bolsa não encontrada com o ID: " + id);
        }
        cadastroBolsa.deleteById(id);
    }
}
