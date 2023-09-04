package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.TipoVinculo;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Vinculo;

import java.util.List;

public interface InterfaceCadastroVinculo {
    Vinculo cadastrarVinculo(Vinculo vinculo);

    Vinculo atualizarVinculo(Vinculo vinculo);

    boolean verificarExistenciaVinculo(Estudante estudante, TipoVinculo tipoVinculo, String dataInicio, String dataFim);
     List<Vinculo> listarVinculosPorEstudante(Estudante estudante);
    Vinculo consultarPorId(Long aLong);
    public List<Vinculo> listarVinculos();
    public void deletarPorId(Long aLong);
}
