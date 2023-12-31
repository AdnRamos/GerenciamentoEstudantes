package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Funcao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.FuncaoDuplicadaException;

import java.util.List;

public interface InterfaceCadastroFuncao {
    Funcao cadastrarFuncao(Funcao funcao) throws FuncaoDuplicadaException;

    Funcao atualizarFuncao(Funcao funcao);

    void deletarFuncao(long id);

    Funcao buscarFuncaoPorId(long id);
    List<Funcao> listarFuncoes();

    List<Funcao> buscarFuncoesPorEstudante(Estudante estudante);

    void verificarFuncaoDuplicada(Estudante estudante, Funcao funcao);
}
