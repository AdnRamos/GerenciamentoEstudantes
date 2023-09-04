package br.edu.ufape.poo.gerenciamentoestudantes.comunicacao;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Bolsa;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.fachada.Fachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BolsaController {
    @Autowired
    public Fachada fachada;

    @GetMapping("/bolsa")
    public List<Bolsa> listarBolsas(){
        return fachada.listarBolsas();
    }
    @GetMapping("/bolsa/{id}")
    public Bolsa consultarBolsaID(@PathVariable long id){
        return fachada.buscarBolsaPorId(id);
    }
    @PostMapping("/bolsa")
    public Bolsa salvarBolsa(@RequestBody Bolsa bolsa){
        return fachada.cadastrarBolsa(bolsa);
    }
    @PatchMapping("/bolsa/{id}")
    public Bolsa atualizarBolsa(@PathVariable long id, @RequestBody Bolsa bolsa){
        bolsa.setId(id);
        return fachada.atualizarBolsa(bolsa);
    }
    @DeleteMapping("/bolsa/{id}")
    public String deletarBolsa(@PathVariable long id){
        fachada.deletarBolsa(id);
        return "Bolsa deletada com sucesso!";
    }

}
