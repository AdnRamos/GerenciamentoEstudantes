package br.edu.ufape.poo.gerenciamentoestudantes.comunicacao;

import java.util.List;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioNaoExisteException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.fachada.Fachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class EstudanteController {
    @Autowired
    public Fachada fachada;

    @GetMapping("/estudante")
    public List<Estudante> listarEstudante() {
        return fachada.listarEstudantes();
    }

    @PostMapping("/estudante")
    public Estudante cadastrarEstudante(@RequestBody Estudante e)
            throws UsuarioDuplicadoException {
        return fachada.salvarEstudante(e);
    }

    @GetMapping("/estudante/{id}")
    public Estudante exibirEstudanteId(@PathVariable long id) {
        return fachada.procurarEstudanteId(id);
    }
    @GetMapping("/estudante/{email}")
    public Estudante exibirEstudanteEmail(@PathVariable String email) throws UsuarioNaoExisteException {
        return fachada.consultarEstudanteEmail(email);
    }


    @PatchMapping("/estudante/{id}")
    public Estudante atualizarDados(@PathVariable long id, @RequestBody Estudante e) throws UsuarioDuplicadoException {
        e.setId(id);
        return fachada.salvarEstudante(e);
    }

    @DeleteMapping("/estudante/{email}")
    public String apagarEstudante(@PathVariable String email)
            throws UsuarioNaoExisteException {

        fachada.removerUsuarioEmail(email);
        return "ok";
    }

}