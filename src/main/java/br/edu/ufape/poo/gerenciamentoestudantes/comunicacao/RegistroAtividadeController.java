package br.edu.ufape.poo.gerenciamentoestudantes.comunicacao;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.RegistroAtividade;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.RegistroAtividadeDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.RegistroAtividadeNaoEncontradoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.fachada.Fachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RegistroAtividadeController {
    @Autowired
    public Fachada fachada;
    @GetMapping("/resgistroAtividade")
    public List<RegistroAtividade> listarRegistrosAtividades(){
        return fachada.buscarTodosRegistrosAtividade();
    }
    @GetMapping("/resgistroAtividade/id")
    public RegistroAtividade buscarRegistroAtividadePorId(long id){
        return fachada.buscarRegistroAtividadePorId(id);
    }
    @PostMapping("/resgistroAtividade")
    public RegistroAtividade salvarRegistroAtividade(RegistroAtividade registroAtividade) throws RegistroAtividadeDuplicadoException {
        return fachada.cadastrarRegistroAtividade(registroAtividade);
    }
    @PatchMapping("/registroAtividade/{id}")
    public RegistroAtividade atualizarRegistro(@PathVariable long id, @RequestBody RegistroAtividade registroAtividade) throws RegistroAtividadeDuplicadoException, RegistroAtividadeNaoEncontradoException {
        return fachada.atualizarRegistroAtividade(registroAtividade);
    }
    @DeleteMapping("/registroAtividade/{id}")
    public String apagarRegistro(@PathVariable long id) throws RegistroAtividadeNaoEncontradoException{
        fachada.excluirRegistroAtividade(id);
        return "Registro de atividade excluido.";
    }
}
