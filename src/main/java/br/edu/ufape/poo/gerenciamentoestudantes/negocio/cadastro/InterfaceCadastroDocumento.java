package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Documento;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.DocumentoInvalidoException;

import java.util.List;

public interface InterfaceCadastroDocumento {
    Documento salvarDocumento(Documento documento) throws DocumentoInvalidoException;
    List<Documento> listarDocumentos();
    Documento buscarDocumentoPorId(long id);

    Documento atualizarDocumento(Documento documento);

    void deletarDocumento(long id);
}
