package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoHorario;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.DiaSemana;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.ModalidadeAtividade;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Horario;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.HorarioConflitoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.HorarioDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.HorarioNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CadastroHorario implements InterfaceCadastroHorario {
    @Autowired
    private InterfaceColecaoHorario colecaoHorario;
    @Override
    public List<Horario> listarHorariosEstudantes(){
        return colecaoHorario.findAll();
    }

    @Override
    public boolean verificarExistenciaHorario(Long id) {
        return colecaoHorario.existsById(id);
    }
    @Override
    public Horario salvarHorario(Horario entity) throws HorarioDuplicadoException{
        if(verificarExistenciaHorario(entity.getId())){
            throw new HorarioDuplicadoException(entity.getId());
        }
        return colecaoHorario.save(entity);
    }
    @Override
    public void atualizarHorario(Horario entity) throws HorarioNaoEncontradoException {
        if (!verificarExistenciaHorario(entity.getId())) {
            throw new HorarioNaoEncontradoException(entity.getId());
        }

        colecaoHorario.save(entity);
    }

    @Override
    public void excluirHorario(Long id) throws HorarioNaoEncontradoException {
        if (!verificarExistenciaHorario(id)) {
            throw new HorarioNaoEncontradoException(id);
        }

        colecaoHorario.deleteById(id);
    }

    /**
     @Override
     public boolean temConflito(Horario horarioNovo, Estudante estudante) {
     List<Horario> horariosEstudante = estudante.getHorarios();

     for (Horario horarioExistente : horariosEstudante) {
     if (horariosConflitantes(horarioNovo, horarioExistente)) {
     return true; // Conflito encontrado
     }
     }

     return false; // Sem conflitos
     }
     */


    private boolean horariosConflitantes(Horario horario1, Horario horario2) {
        // Converta as horas de início e término dos horários em minutos para facilitar a comparação
        int horaInicio1 = converterParaMinutos(horario1.getHoraInicio());
        int horaFim1 = converterParaMinutos(horario1.getHoraFim());
        int horaInicio2 = converterParaMinutos(horario2.getHoraInicio());
        int horaFim2 = converterParaMinutos(horario2.getHoraFim());

        // Verifique se os horários se sobrepõem
        return (horaInicio1 <= horaFim2 && horaFim1 >= horaInicio2);
    }

    private int converterParaMinutos(String hora) {
        String[] partesHora = hora.split(":");
        int horas = Integer.parseInt(partesHora[0]);
        int minutos = Integer.parseInt(partesHora[1]);
        return horas * 60 + minutos;
    }



}
