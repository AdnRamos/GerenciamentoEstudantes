package br.edu.ufape.poo.gerenciamentoestudantes.comunicacao;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Funcao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.FuncaoDuplicadaException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.fachada.Fachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FuncaoController {
    @Autowired
    public Fachada fachada;

    @GetMapping("/funcao/{id}")
    public Funcao consultarFuncaoID(@PathVariable long id){
        return fachada.buscarFuncaoPorId(id);
    }
    @GetMapping("/funcao/{estudante}")
    public List<Funcao> consultarFuncoesEstudante(@RequestBody Estudante estudante){
        return fachada.buscarFuncoesPorEstudante(estudante);
    }
    @PostMapping("/funcao")
    public Funcao salvarFuncao(@RequestBody Funcao funcao, @RequestBody Estudante estudante) throws FuncaoDuplicadaException {
        return fachada.cadastrarFuncao(estudante, funcao);
    }
    @PatchMapping("/funcao")
    public String atualizarFuncao(@RequestBody Funcao funcao){
        fachada.atualizarFuncao(funcao);
        return "Funcao atualziada com sucesso!";
    }
    @DeleteMapping("/funcao")
    public String deletarFuncao(@PathVariable long id){
        fachada.deletarFuncao(id);
        return "Funcao deletada com sucesso!";
    }
}
