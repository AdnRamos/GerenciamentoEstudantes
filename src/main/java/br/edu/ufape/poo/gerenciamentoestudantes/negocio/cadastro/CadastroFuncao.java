package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoEstudante;
import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoFuncao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Funcao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.FuncaoDuplicadaException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.FuncaoNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroFuncao implements InterfaceCadastroFuncao {

    @Autowired
    private InterfaceColecaoFuncao colecaoFuncao;
    @Autowired
    private InterfaceColecaoEstudante colecaoEstudante;

    @Override
    public Funcao cadastrarFuncao(Funcao funcao) throws FuncaoDuplicadaException {
        Estudante estudante = funcao.getEstudante();

        // Verifique se o estudante já existe no banco de dados
        Estudante estudanteExistente = colecaoEstudante.findByMatricula(estudante.getMatricula());

        if (estudanteExistente == null) {
            // O estudante não existe, então salve-o
            estudante = colecaoEstudante.save(estudante);
        } else {
            // O estudante já existe, use o existente
            estudante = estudanteExistente;
        }

        // Associe o estudante à função
        estudante.addFuncao(funcao);
        funcao.setEstudante(estudante);

        // Verifique se a função é duplicada
        verificarFuncaoDuplicada(estudante, funcao);

        // Salve a função
        return colecaoFuncao.save(funcao);
    }




    @Override
    public Funcao atualizarFuncao(Funcao funcao) {
        Funcao funcaoExistente = buscarFuncaoPorId(funcao.getId());

        if (funcao.getEstudante() != null) {
            funcaoExistente.setEstudante(funcao.getEstudante());
        }
        if (funcao.getDataFim() != null) {
            funcaoExistente.setDataFim(funcao.getDataFim());
        }
        if (funcao.getDataInicio() != null) {
            funcaoExistente.setDataInicio(funcao.getDataInicio());
        }
        if (funcao.getTipoFuncao() != null) {
            funcaoExistente.setTipoFuncao(funcao.getTipoFuncao());
        }

        return colecaoFuncao.save(funcaoExistente);

    }

    @Override
    public void deletarFuncao(long id) {
        Funcao funcao = buscarFuncaoPorId(id);
        colecaoFuncao.delete(funcao);
    }

    @Override
    public Funcao buscarFuncaoPorId(long id) {
        return colecaoFuncao.findById(id)
                .orElseThrow(() -> new FuncaoNaoEncontradaException(id));
    }

    @Override
    public List<Funcao> buscarFuncoesPorEstudante(Estudante estudante) {
        return colecaoFuncao.findByEstudante(estudante);
    }
    @Override
    public List<Funcao> listarFuncoes() {
        return colecaoFuncao.findAll();
    }

    @Override
    public void verificarFuncaoDuplicada(Estudante estudante, Funcao funcao) {
        List<Funcao> funcoes = colecaoFuncao.findByEstudante(estudante);

        for (Funcao f : funcoes) {
            if (f.getTipoFuncao() == funcao.getTipoFuncao()) {
                throw new FuncaoDuplicadaException("Função duplicada para o estudante.");
            }
        }
    }

}