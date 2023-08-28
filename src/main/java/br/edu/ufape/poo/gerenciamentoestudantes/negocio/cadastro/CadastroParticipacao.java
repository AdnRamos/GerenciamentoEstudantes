package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoParticipacao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Participacao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Projeto;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.ParticipacaoDuplicadaException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.ParticipacaoNaoEncontradaException;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroParticipacao implements InterfaceCadastroParticipacao {

    @Autowired
    private InterfaceColecaoParticipacao colecaoParticipacao;

    @Override
    public Participacao cadastrarParticipacao(Participacao participacao) throws ParticipacaoDuplicadaException {
        if(participacao.getEstudante() != null && participacao.getProjeto() != null){
            if (colecaoParticipacao.existsByEstudanteAndProjeto(participacao.getEstudante(), participacao.getProjeto())) {
                throw new ParticipacaoDuplicadaException("Participação duplicada para o estudante e projeto.");
            }
        }
        return colecaoParticipacao.save(participacao);
    }

    @Override
    public void removerParticipacao(Participacao participacao) throws ParticipacaoNaoEncontradaException {
        if (!colecaoParticipacao.existsById(participacao.getId())) {
            throw new ParticipacaoNaoEncontradaException("Participação não encontrada.");
        }
        colecaoParticipacao.delete(participacao);
    }

    @Override
    public Participacao consultarParticipacaoPorId(long id) throws ParticipacaoNaoEncontradaException {
        return colecaoParticipacao.findById(id)
                .orElseThrow(() -> new ParticipacaoNaoEncontradaException("Participação não encontrada."));
    }

    @Override
    public List<Participacao> listarParticipacoesPorEstudante(Estudante estudante) {
        return colecaoParticipacao.findByEstudante(estudante);
    }

    @Override
    public List<Participacao> listarParticipacoesPorProjeto(Projeto projeto) {
        return colecaoParticipacao.findByProjeto(projeto);
    }
}
