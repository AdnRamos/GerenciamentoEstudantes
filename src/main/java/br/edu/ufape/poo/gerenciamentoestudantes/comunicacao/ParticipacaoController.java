package br.edu.ufape.poo.gerenciamentoestudantes.comunicacao;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Participacao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Projeto;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.ParticipacaoDuplicadaException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.ParticipacaoNaoEncontradaException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.fachada.Fachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ParticipacaoController {
    @Autowired
    public Fachada fachada;

    @GetMapping("/participacao/estudantes")
    public List<Participacao> listarParticipacaoEstudante(@RequestBody Estudante estudante){
        return fachada.listarParticipacoesPorEstudante(estudante);
    }
    @GetMapping("/participacao/projetos")
    public List<Participacao> listarParticipacaoProjeto(@RequestBody Projeto projeto){
        return fachada.listarParticipacoesPorProjeto(projeto);
    }
    @GetMapping("/participacao/{id}")
    public Participacao consultarParticipacaoID(@PathVariable long id) throws ParticipacaoNaoEncontradaException {
        return fachada.consultarParticipacaoPorId(id);
    }
    @PostMapping("/participacao")
    public Participacao salvarParticipacao(@RequestBody Participacao participacao) throws ParticipacaoDuplicadaException {
        return fachada.cadastrarParticipacao(participacao);
    }
    @DeleteMapping("/participacao")
    public String deletarParticipacao(@RequestBody Participacao participacao) throws ParticipacaoNaoEncontradaException {
        fachada.removerParticipacao(participacao);
        return "Participacao excluida com sucesso!";
    }

}
