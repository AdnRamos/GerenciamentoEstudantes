package br.edu.ufape.poo.gerenciamentoestudantes.comunicacao;

import java.util.List;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Orientador;
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
public class OrientadorController {
    @Autowired
    public Fachada fachada;

    @GetMapping("/orientador")
    public List<Orientador> listarOrientador() {
        return fachada.listarOrientadores();
    }

    @PostMapping("/orientador")
    public Orientador cadastrarOrientador(@RequestBody Orientador orientador)
            throws UsuarioDuplicadoException {
        return fachada.salvarOrientador(orientador);
    }

    @GetMapping("/orientador/email/{email}")
    public Orientador exibirOrientadorEmail(@PathVariable String email) throws UsuarioNaoExisteException {
        return fachada.consultarOrientadorPorEmail(email);
    }


    @PatchMapping("/orientador/{id}")
    public Orientador atualizarDados(@PathVariable long id, @RequestBody Orientador orientador) throws UsuarioDuplicadoException {
        orientador.setId(id);
        return fachada.salvarOrientador(orientador);
    }

    @DeleteMapping("/orientador/{email}")
    public String apagarOrientador(@PathVariable String email)
            throws UsuarioNaoExisteException {

        fachada.removerUsuarioEmail(email);
        return "ok";
    }

}