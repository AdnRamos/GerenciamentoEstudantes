package br.edu.ufape.poo.gerenciamentoestudantes.comunicacao;


import java.util.List;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Horario;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.HorarioDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.HorarioNaoEncontradoException;
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
public class HorarioController {
    @Autowired
    public Fachada fachada;

    @GetMapping("/horario")
    public List<Horario> listarHorario() {
        return fachada.listarHorariosEstudantes();
    }

    @PostMapping("/horario")
    public Horario cadastrarHorario(@RequestBody Horario horario)
            throws HorarioDuplicadoException {
        return fachada.salvarHorario(horario);
    }

    @PatchMapping("/horario/{id}")
    public Horario atualizarDados(@PathVariable long id, @RequestBody Horario horario) throws HorarioNaoEncontradoException {
        horario.setId(id);
        return fachada.atualizarHorario(horario);
    }

    @DeleteMapping("/horario/{email}")
    public String apagarHorario(@PathVariable long id)
            throws HorarioNaoEncontradoException {

        fachada.excluirHorario(id);
        return "ok";
    }

}