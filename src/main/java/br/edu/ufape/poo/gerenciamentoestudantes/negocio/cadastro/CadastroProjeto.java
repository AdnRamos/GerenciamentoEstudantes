package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoProjeto;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Projeto;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.ProjetoDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.ProjetoNaoExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroProjeto {

    @Autowired
    private InterfaceColecaoProjeto colecaoProjeto;

    public List<Projeto> listarProjetos() {
        return colecaoProjeto.findAll();
    }

    public Projeto salvarProjeto(Projeto projeto) throws ProjetoDuplicadoException {
        try {
            consultarProjetoPorNome(projeto.getNomeProjeto());
            throw new ProjetoDuplicadoException(projeto.getNomeProjeto());
        } catch (ProjetoNaoExisteException ignored) {
            return colecaoProjeto.save(projeto);
        }
    }

    @Override
    public void removerProjetoPorNome(String nomeProjeto) throws ProjetoNaoExisteException {
        Projeto projeto = consultarProjetoPorNome(nomeProjeto);
        colecaoProjeto.delete(projeto);
    }

    @Override
    public Projeto consultarProjetoPorNome(String nomeProjeto) throws ProjetoNaoExisteException {
        Projeto projeto = colecaoProjeto.findByNomeProjeto(nomeProjeto);
        if (projeto == null) {
            throw new ProjetoNaoExisteException(nomeProjeto);
        }
        return projeto;
    }

    @Override
    public boolean verificarExistenciaProjetoId(Long id) {
        return colecaoProjeto.existsById(id);
    }
}
