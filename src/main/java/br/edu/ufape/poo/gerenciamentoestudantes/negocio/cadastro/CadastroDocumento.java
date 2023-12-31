package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoDocumento;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Documento;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroDocumento implements InterfaceCadastroDocumento {
    @Autowired
    private InterfaceColecaoDocumento colecaoDocumento;

    @Override
    public Documento salvarDocumento(Documento documento) throws DocumentoInvalidoException {
        verificarDocumentoDuplicado(documento.getNome());
        try {
            return colecaoDocumento.save(documento);
        } catch (Exception e) {
            throw new DocumentoInvalidoException("Falha ao cadastrar o documento", e);
        }
    }
    @Override
    public List<Documento> listarDocumentos() {
        return colecaoDocumento.findAll();
    }

    @Override
    public Documento buscarDocumentoPorId(long id) {
        Optional<Documento> documento = colecaoDocumento.findById(id);
        return documento.orElseThrow(() -> new DocumentoNaoEncontradoException(id));
    }

    @Override
    public Documento atualizarDocumento(Documento documentoAtualizado) {
        Documento documentoExistente = buscarDocumentoPorId(documentoAtualizado.getId());
        if (documentoAtualizado.getNome() != null) {
            documentoExistente.setNome(documentoAtualizado.getNome());
        }
        if (documentoAtualizado.getDescricao() != null) {
            documentoExistente.setDescricao(documentoAtualizado.getDescricao());
        }
        if (documentoAtualizado.getLink() != null) {
            documentoExistente.setLink(documentoAtualizado.getLink());
        }
        return colecaoDocumento.save(documentoExistente);
    }


    @Override
    public void deletarDocumento(long id) {
        verificarDocumentoExistente(id);

        try {
            colecaoDocumento.deleteById(id);
        } catch (Exception e) {
            throw new DocumentoNaoDeletadoException(id);
        }
    }

    private void verificarDocumentoDuplicado(String nome) {
        if (colecaoDocumento.findByNome(nome).isPresent()) {
            throw new DocumentoDuplicadoException(nome);
        }
    }

    private void verificarDocumentoExistente(long id) {
        if (!colecaoDocumento.existsById(id)) {
            throw new DocumentoNaoEncontradoException(id);
        }
    }

}
