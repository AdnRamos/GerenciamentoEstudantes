package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.TipoVinculo;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Vinculo;

public interface InterfaceCadastroVinculo {
    Vinculo cadastrarVinculo(Estudante estudante, Vinculo vinculo);

    void atualizarVinculo(Vinculo vinculo);

    boolean verificarExistenciaVinculo(Estudante estudante, TipoVinculo tipoVinculo, String dataInicio, String dataFim);
}
