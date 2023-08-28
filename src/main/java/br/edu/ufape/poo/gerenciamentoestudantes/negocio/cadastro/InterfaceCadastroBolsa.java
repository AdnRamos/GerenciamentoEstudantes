package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Bolsa;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.BolsaDuplicadaException;

import java.util.List;

public interface InterfaceCadastroBolsa {
    Bolsa cadastrarBolsa(Bolsa bolsa) throws BolsaDuplicadaException;

    Bolsa buscarBolsaPorId(long id);

    List<Bolsa> listarBolsas();

    Bolsa atualizarBolsa(Bolsa bolsa);

    void deletarBolsa(long id);
}
