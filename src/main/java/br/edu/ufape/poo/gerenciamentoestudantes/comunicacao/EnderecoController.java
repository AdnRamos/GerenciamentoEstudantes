package br.edu.ufape.poo.gerenciamentoestudantes.comunicacao;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Endereco;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioNaoExisteException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.fachada.Fachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apa/v1")
public class EnderecoController {
    @Autowired
    public Fachada fachada;

    @GetMapping("/endereco")
    public List<Endereco> listarEndereco() {
        return fachada.listarEnderecos();
    }
    @PostMapping("/endereco")
    public Endereco salvarEnderecp(@RequestBody Endereco e){
        return fachada.salvarEndereco(e);
    }
    @GetMapping("/endereco/{id}")
    public Optional<Endereco> consultarEnderecoID(@PathVariable long id) {

        return fachada.buscarEnderecoId(id);
    }


    @DeleteMapping("/endereco/{email}")
    public String Endereco(@PathVariable Long id){

        fachada.apagarEnderecoId(id);
        return "ok";
    }
}
