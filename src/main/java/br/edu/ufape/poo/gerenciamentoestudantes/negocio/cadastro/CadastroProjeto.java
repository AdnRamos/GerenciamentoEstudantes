package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoProjeto;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Projeto;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.ProjetoDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.ProjetoNaoExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroProjeto implements InterfaceCadastroProjeto {

    @Autowired
    private InterfaceColecaoProjeto cadastroProjeto;

    @Override
    public List<Projeto> listarProjetos() {
        return cadastroProjeto.findAll();
    }

    @Override
    public Projeto salvarProjeto(Projeto projeto) throws ProjetoDuplicadoException {
        // Verifica se já existe um projeto com o mesmo nome
        if (cadastroProjeto.existsByNomeProjeto(projeto.getNomeProjeto())) {
            throw new ProjetoDuplicadoException(projeto.getNomeProjeto());
        }

        // Se não houver duplicação, salva o projeto
        return cadastroProjeto.save(projeto);
    }


    public void removerProjetoPorId(long id) throws ProjetoNaoExisteException {
        Projeto projeto = consultarProjetoPorId(id);
        cadastroProjeto.delete(projeto);
    }

    public Projeto consultarProjetoPorId(long id) throws ProjetoNaoExisteException {
        return cadastroProjeto.findById(id).orElseThrow(() -> new ProjetoNaoExisteException(id));
    }

    @Override
    public boolean verificarExistenciaProjetoId(Long id) {
        return cadastroProjeto.existsById(id);
    }
}
