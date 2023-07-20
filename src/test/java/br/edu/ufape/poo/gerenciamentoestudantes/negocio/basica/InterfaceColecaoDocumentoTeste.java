package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoDocumento;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InterfaceColecaoDocumentoTeste {
    @Autowired
    private InterfaceColecaoDocumento ColecaoDocumentos;

    @Test
    void CadastrarDocumentoTeste(){
        long qtdDocumentos = ColecaoDocumentos.count();
        Documento doc = new Documento("Teste", "Nao sei de nada mas queria saber o que ta acontecendo", "www.drivesdo.ufape.edu.br");
        ColecaoDocumentos.save(doc);
        long qtdDocumentos1 = ColecaoDocumentos.count();
        assertEquals(qtdDocumentos+1,qtdDocumentos1);
    }
}
