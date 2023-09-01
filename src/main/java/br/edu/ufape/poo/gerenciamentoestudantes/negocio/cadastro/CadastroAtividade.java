package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoHorario;
import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoRegistro;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Documento;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Horario;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.RegistroAtividade;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.HorarioDuplicadoException;
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
    @Autowired
    private InterfaceColecaoHorario colecaoHorario;


    @Override
    public RegistroAtividade salvarRegistroAtividade(RegistroAtividade registroAtividade) {
        if (registroAtividade.getEstudante() != null) {
            if (verificarExistenciaRegistroAtividadeDuplicado(registroAtividade)) {
                throw new RegistroAtividadeDuplicadoException("Registro de atividade já cadastrado");
            }
        }

        if (registroAtividade.getHorario() != null) {
            Horario horario = registroAtividade.getHorario();
            colecaoHorario.save(horario);
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
        RegistroAtividade registroExistente = buscarRegistroAtividadePorId(registroAtividade.getId());
        if (registroAtividade.getHorario() != null) {
            registroExistente.setHorario(registroAtividade.getHorario());
        }
        if (registroAtividade.getDescricao() != null) {
            registroExistente.setDescricao(registroAtividade.getDescricao());
        }
        if (registroAtividade.getEstudante() != null) {
            registroExistente.setEstudante(registroAtividade.getEstudante());
        }

        return colecaoRegistroAtividade.save(registroExistente);
    }

    @Override
    public void excluirRegistroAtividade(long id) throws RegistroAtividadeNaoEncontradoException {
        Optional<RegistroAtividade> registroExistente = colecaoRegistroAtividade.findById(id);

        if (registroExistente.isEmpty()) {
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
