package br.edu.ufape.poo.gerenciamentoestudantes.comunicacao;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Documento;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.DocumentoInvalidoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.fachada.Fachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DocumentoController {
    @Autowired
    public Fachada fachada;

    @GetMapping("/documento")
    public List<Documento> listarDocumentos(){
        return fachada.listarDocumentos();
    }
    @GetMapping("/documento/{id}")
    public Documento consuldarDocumentoId(@PathVariable long id){
        return fachada.buscarDocumentoPorId(id);
    }
    @PostMapping("/documento")
    public Documento salvarDocumento(@RequestBody Documento documento) throws DocumentoInvalidoException {
        return fachada.salvarDocumento(documento);
    }
    @PatchMapping("/documento/{id}")
    public Documento atualizarDocumento(@PathVariable long id, @RequestBody Documento documento){
        documento.setId(id);
        return fachada.atualizarDocumento(documento);
    }
    @DeleteMapping("/documento/{id}")
    public String deletarDocumento(@PathVariable long id){
        fachada.deletarDocumento(id);
        return "Documento deletado com sucesso.";
    }
}
