package br.edu.ufape.poo.gerenciamentoestudantes.comunicacao;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Projeto;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.ProjetoDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.ProjetoNaoExisteException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.fachada.Fachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProjetoController {
    @Autowired
    public Fachada fachada;

    @GetMapping("/projeto")
    public List<Projeto>  listarProjetos(){
        return fachada.listarProjetos();
    }
    @GetMapping("/projeto/{id}")
    public Projeto buscarProjetoId(@PathVariable long id) throws ProjetoNaoExisteException {
        return fachada.consultarProjetoPorId(id);
    }
    @PostMapping("/projeto")
    public Projeto cadastrarProjeto(@RequestBody Projeto projeto) throws ProjetoDuplicadoException, ProjetoNaoExisteException {
        return fachada.salvarProjeto(projeto);
    }

    @DeleteMapping("/projeto/{id}")
    public String deletarProjeto(@PathVariable long id) throws ProjetoNaoExisteException {
        fachada.removerProjetoPorId(id);
        return "Projeto removido com sucesso.";
    }
}
