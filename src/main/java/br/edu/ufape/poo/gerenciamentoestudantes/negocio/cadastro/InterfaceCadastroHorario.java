package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Horario;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.HorarioDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.HorarioNaoEncontradoException;

import java.util.List;

public interface InterfaceCadastroHorario {
    List<Horario> listarHorariosEstudantes();

    boolean verificarExistenciaHorario(Long id);

    Horario salvarHorario(Horario entity) throws HorarioDuplicadoException;

    void atualizarHorario(Horario entity) throws HorarioNaoEncontradoException;

    void excluirHorario(Long id) throws HorarioNaoEncontradoException;

    boolean temConflito(Horario horarioNovo, Estudante estudante);
}
