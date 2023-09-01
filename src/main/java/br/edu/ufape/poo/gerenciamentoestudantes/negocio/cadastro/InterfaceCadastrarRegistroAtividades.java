package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.RegistroAtividade;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.HorarioDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.RegistroAtividadeDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.RegistroAtividadeNaoEncontradoException;

import java.util.List;

public interface InterfaceCadastrarRegistroAtividades {
    RegistroAtividade salvarRegistroAtividade(RegistroAtividade registroAtividade) throws HorarioDuplicadoException;

    RegistroAtividade buscarRegistroAtividadePorId(long id);

    List<RegistroAtividade> buscarTodosRegistrosAtividade();

    RegistroAtividade atualizarRegistroAtividade(RegistroAtividade registroAtividade) throws RegistroAtividadeNaoEncontradoException, RegistroAtividadeDuplicadoException;

    void excluirRegistroAtividade(long id) throws RegistroAtividadeNaoEncontradoException;
}
