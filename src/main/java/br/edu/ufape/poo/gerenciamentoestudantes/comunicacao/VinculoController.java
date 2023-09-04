package br.edu.ufape.poo.gerenciamentoestudantes.comunicacao;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Vinculo;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.VinculoDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.fachada.Fachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class VinculoController {
    @Autowired
    public Fachada fachada;
    @GetMapping("/vinculo")
    public List<Vinculo> listarVinculos(){
        return fachada.listarVinculos();
    }
    @GetMapping("/vinculos/estudante/{estudante}")
    public List<Vinculo> listarVinculosPorEstudante(@RequestBody Estudante estudante){
        return fachada.listarVinculosPorEstudante(estudante);
    }
    @GetMapping("/vinculo/{id}")
    public Vinculo consultarVinculoID(@PathVariable long id){
        return fachada.consultarVinculoPorId(id);
    }
    @PostMapping("/vinculo")
    public Vinculo cadastrarVinculo(@RequestBody Vinculo v) throws VinculoDuplicadoException, UsuarioDuplicadoException {
        return fachada.cadastrarVinculo(v);
    }
    @PatchMapping("/vinculo/{id}")
    public Vinculo atualizarVinculo(@PathVariable long id, @RequestBody Vinculo v){
        v.setId(id);
        return fachada.atualizarVinculo(v);
    }
    @DeleteMapping("/vinculo/{id}")
    public String deletarVinculo(@PathVariable long id){
        fachada.deletarVinculoPorId(id);
        return "Vinculo deletado com sucesso";
    }



}
