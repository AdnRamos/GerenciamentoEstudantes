package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoRegistro;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.RegistroAtividade;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.RegistroAtividadeDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.RegistroAtividadeNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroAtividade implements InterfaceCadastrarRegistroAtividades {
    @Autowired
    private InterfaceColecaoRegistro colecaoRegistroAtividade;

    @Override
    public RegistroAtividade salvarRegistroAtividade(RegistroAtividade registroAtividade) {
        if(registroAtividade.getEstudante() != null ){
            if (verificarExistenciaRegistroAtividadeDuplicado(registroAtividade)) {
                throw new RegistroAtividadeDuplicadoException("Registro de atividade já cadastrado");
            }
        }

        return colecaoRegistroAtividade.save(registroAtividade);
    }

    @Override
    public RegistroAtividade buscarRegistroAtividadePorId(long id) {
        return colecaoRegistroAtividade.findById(id)
                .orElseThrow(() -> new RegistroAtividadeNaoEncontradoException(id));
    }

    @Override
    public List<RegistroAtividade> buscarTodosRegistrosAtividade() {
        return colecaoRegistroAtividade.findAll();
    }

    @Override
    public RegistroAtividade atualizarRegistroAtividade(RegistroAtividade registroAtividade) throws RegistroAtividadeNaoEncontradoException, RegistroAtividadeDuplicadoException {
        // Verificar se o registro de atividade existe
        Optional<RegistroAtividade> registroExistente = colecaoRegistroAtividade.findById(registroAtividade.getId());

        if (!registroExistente.isPresent()) {
            throw new RegistroAtividadeNaoEncontradoException(registroAtividade.getId());
        }
        // Verificar se existe um registro de atividade duplicado com a mesma data
        if (verificarExistenciaRegistroAtividadeDuplicado(registroAtividade)) {
            throw new RegistroAtividadeDuplicadoException("Já existe um registro de atividade com a mesma data");
        }
        // Atualizar os dados do registro de atividade existente
        RegistroAtividade registroAtualizado = registroExistente.get();
        registroAtualizado.setDescricao(registroAtividade.getDescricao());
        registroAtualizado.setHorario(registroAtividade.getHorario());

        return colecaoRegistroAtividade.save(registroAtualizado);
    }

    @Override
    public void excluirRegistroAtividade(long id) throws RegistroAtividadeNaoEncontradoException {
        Optional<RegistroAtividade> registroExistente = colecaoRegistroAtividade.findById(id);

        if (!registroExistente.isPresent()) {
            throw new RegistroAtividadeNaoEncontradoException(id);
        }

        colecaoRegistroAtividade.delete(registroExistente.get());
    }
    private boolean verificarExistenciaRegistroAtividadeDuplicado(RegistroAtividade registroAtividade) {
        // Consulta ao banco de dados para verificar se já existe um registro de atividade

        List<RegistroAtividade> registrosExistentes = colecaoRegistroAtividade
                .findByEstudanteAndHorario(registroAtividade.getEstudante(), registroAtividade.getHorario());

        // Verifique se algum registro de atividade já existe com o mesmo horário, excluindo o próprio registro atual
        for (RegistroAtividade registroExistente : registrosExistentes) {
            if (!registroExistente.equals(registroAtividade)) {
                return true; // Já existe um registro de atividade com o mesmo horário
            }
        }

        return false; // Não existe registro de atividade duplicado
    }


}
