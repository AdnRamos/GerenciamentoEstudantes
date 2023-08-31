package br.edu.ufape.poo.gerenciamentoestudantes.comunicacao;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Inscricao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.fachada.Fachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InscricaoController {
    @Autowired
    public Fachada fachada;

    @GetMapping("/inscricao")
    public List<Inscricao> listarInscricoesPorEstudante(@RequestBody Estudante estudante){
        return fachada.listarInscricoesPorEstudante(estudante);
    }
    @GetMapping("/inscricao/{id}")
    public Inscricao consultarInscricaoID(@PathVariable long id){
        return fachada.buscarInscricaoPorId(id);
    }
    @PostMapping("/inscricao")
    public Inscricao salvarInscricao (@RequestBody Inscricao inscricao){
        return fachada.cadastrarInscricao(inscricao);
    }
    @DeleteMapping("/inscricao")
    public String deletarInscricao(@PathVariable long id){
        fachada.removerInscricaoPorId(id);
        return "Inscricao cancelada com sucesso!";
    }
}
