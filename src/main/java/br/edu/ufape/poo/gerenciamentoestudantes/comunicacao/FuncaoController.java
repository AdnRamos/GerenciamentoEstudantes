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
    @GetMapping("/funcao")
    public List<Funcao> listarFuncoes(){
        return fachada.listarFuncoes();
    }

    @GetMapping("/funcao/{id}")
    public Funcao consultarFuncaoID(@PathVariable long id){
        return fachada.buscarFuncaoPorId(id);
    }
    @GetMapping("/funcao/estudante/{estudante}")
    public List<Funcao> consultarFuncoesEstudante(@RequestBody Estudante estudante){
        return fachada.buscarFuncoesPorEstudante(estudante);
    }
    @PostMapping("/funcao")
    public Funcao salvarFuncao(@RequestBody Funcao funcao) throws FuncaoDuplicadaException {
        return fachada.cadastrarFuncao(funcao);
    }
    @PatchMapping("/funcao/{id}")
    public Funcao atualizarFuncao(@PathVariable long id, @RequestBody Funcao funcao){
        funcao.setId(id);
        return fachada.atualizarFuncao(funcao);

    }
    @DeleteMapping("/funcao/{id}")
    public String deletarFuncao(@PathVariable long id){
        fachada.deletarFuncao(id);
        return "Funcao deletada com sucesso!";
    }
}
