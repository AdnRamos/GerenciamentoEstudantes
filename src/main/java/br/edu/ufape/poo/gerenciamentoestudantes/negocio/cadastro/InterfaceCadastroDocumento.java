package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Documento;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.DocumentoInvalidoException;

public interface InterfaceCadastroDocumento {
    Documento salvarDocumento(Documento documento) throws DocumentoInvalidoException;

    Documento buscarDocumentoPorId(long id);

    Documento atualizarDocumento(Documento documento);

    void deletarDocumento(long id);
}
