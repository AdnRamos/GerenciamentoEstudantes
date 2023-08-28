package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoFuncao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.TipoFuncao;
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

    @Override
    public Funcao cadastrarFuncao(Estudante estudante, Funcao funcao) throws FuncaoDuplicadaException {
        verificarFuncaoDuplicada(estudante, funcao); // Verifica se é duplicada e lança exceção se for

        estudante.addFuncao(funcao);
        return colecaoFuncao.save(funcao);
    }

    @Override
    public void atualizarFuncao(Funcao funcao) {
        Funcao funcaoExistente = buscarFuncaoPorId(funcao.getId());

        funcaoExistente.setTipoFuncao(funcao.getTipoFuncao());
        funcaoExistente.setDataInicio(funcao.getDataInicio());
        funcaoExistente.setDataFim(funcao.getDataFim());

        colecaoFuncao.save(funcaoExistente);
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
    public void verificarFuncaoDuplicada(Estudante estudante, Funcao funcao) {
        List<Funcao> funcoes = colecaoFuncao.findByEstudante(estudante);

        for (Funcao f : funcoes) {
            if (f.getTipoFuncao() == funcao.getTipoFuncao()) {
                throw new FuncaoDuplicadaException("Função duplicada para o estudante.");
            }
        }
    }

}