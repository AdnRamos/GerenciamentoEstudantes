package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Projeto;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.ProjetoDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.ProjetoNaoExisteException;

import java.util.List;
import java.util.Optional;

public interface InterfaceCadastroProjeto {
    List<Projeto> listarProjetos();

    Projeto salvarProjeto(Projeto projeto) throws ProjetoDuplicadoException, ProjetoNaoExisteException;

    void removerProjetoPorId(long id) throws ProjetoNaoExisteException;

    Projeto consultarProjetoPorId(long id) throws ProjetoNaoExisteException;

    boolean verificarExistenciaProjetoId(Long id);
}
