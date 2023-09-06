package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Participacao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Projeto;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.ParticipacaoDuplicadaException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.ParticipacaoNaoEncontradaException;

import java.util.List;

public interface InterfaceCadastroParticipacao {
    Participacao cadastrarParticipacao(Participacao participacao) throws ParticipacaoDuplicadaException;

    void removerParticipacao(Participacao participacao) throws ParticipacaoNaoEncontradaException;
    List<Participacao> listarParticipacoes();

    Participacao consultarParticipacaoPorId(long id) throws ParticipacaoNaoEncontradaException;

    List<Participacao> listarParticipacoesPorEstudante(Estudante estudante);

    List<Participacao> listarParticipacoesPorProjeto(Projeto projeto);
}
