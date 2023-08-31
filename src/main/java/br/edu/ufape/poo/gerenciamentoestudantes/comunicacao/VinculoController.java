package br.edu.ufape.poo.gerenciamentoestudantes.comunicacao;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Vinculo;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.VinculoDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.fachada.Fachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class VinculoController {
    @Autowired
    public Fachada fachada;

    @PostMapping("/vinculo")
    public Vinculo cadastrarVinculo(@RequestBody Vinculo v, @RequestBody Estudante e) throws VinculoDuplicadoException{
        return fachada.cadastrarVinculo(e, v);
    }
    @PatchMapping("/vinculo/{id}")
    public Vinculo atualizarVinculo(@PathVariable long id, @RequestBody Vinculo v){
        v.setId(id);
        return fachada.atualizarVinculo(v);
    }



}
