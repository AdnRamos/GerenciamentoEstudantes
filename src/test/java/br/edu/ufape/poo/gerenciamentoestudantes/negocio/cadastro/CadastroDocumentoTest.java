package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Documento;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.DocumentoDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.DocumentoInvalidoException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CadastroDocumentoTest {

    @Autowired
    private InterfaceCadastroDocumento cadastroDocumento;

    @Test
    public void cadastrarDocumentoTeste() throws DocumentoInvalidoException {
        Documento documento = new Documento("Documento1", "Descrição do Documento", "link1");

        Documento cadastrado = cadastroDocumento.salvarDocumento(documento);

        assertNotNull(cadastrado);
        assertEquals(documento.getNome(), cadastrado.getNome());
    }

    @Test
    public void cadastrarDocumentoDuplicadoTeste() throws DocumentoInvalidoException {
        Documento documento = new Documento("desgraçaaaaa", "asdfasdfasdf do Documento", "link1");

        cadastroDocumento.salvarDocumento(documento);

        assertThrows(DocumentoDuplicadoException.class, () -> cadastroDocumento.salvarDocumento(documento));
    }

    @Test
    public void buscarDocumentoPorIdTeste() throws DocumentoInvalidoException {
        Documento documento = new Documento("Documento2", "Descrição do Documento", "link2");

        cadastroDocumento.salvarDocumento(documento);

        Documento encontrado = cadastroDocumento.buscarDocumentoPorId(documento.getId());

        assertNotNull(encontrado);
        assertEquals(documento.getId(), encontrado.getId());
    }

}
