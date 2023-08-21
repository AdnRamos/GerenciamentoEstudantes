package br.edu.ufape.poo.gerenciamentoestudantes.negocio.fachada;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.DiaSemana;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.ModalidadeAtividade;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.TipoVinculo;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Horario;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Orientador;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Vinculo;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.InterfaceCadastroEstudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.InterfaceCadastroHorario;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.InterfaceCadastroOrientador;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.InterfaceCadastroVinculo;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.HorarioDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.HorarioNaoEncontradoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioNaoExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Fachada {
    @Autowired
    private InterfaceCadastroEstudante cadastroEstudante;
    @Autowired
    private InterfaceCadastroOrientador cadastroOrientador;
    @Autowired
    private InterfaceCadastroHorario cadastroHorario;
    @Autowired
    private InterfaceCadastroVinculo cadastroVinculo;


    //Estudante:
    public Estudante consultarEstudanteEmail(String email) throws UsuarioNaoExisteException {
        return cadastroEstudante.consultarEstudantePorEmail(email);
    }
    public Estudante procurarEstudanteId(Long id) {
        return cadastroEstudante.consultarEstudantePorId(id);
    }
    public List<Estudante> listarEstudantes() {
        return cadastroEstudante.listarEstudantes();
    }
    public boolean verificarExistenciaEstudanteId(Long id) {
        return cadastroEstudante.verificarExistenciaEstudanteId(id);
    }
    public Estudante salvarEstudante(Estudante entity) throws UsuarioDuplicadoException {
        return cadastroEstudante.salvarEstudante(entity);
    }

    public void removerUsuarioEmail(String email) throws UsuarioNaoExisteException {
        cadastroEstudante.removerUsuarioEmail(email);
    }
    //Orientador

    public List<Orientador> listarOrientadores() {
        return cadastroOrientador.listarOrientadores();
    }

    public Orientador salvarOrientador(Orientador entity) throws UsuarioDuplicadoException {
        return cadastroOrientador.salvarOrientador(entity);
    }

    public Orientador consultarOrientadorPorEmail(String email) throws UsuarioNaoExisteException {
        return cadastroOrientador.consultarOrientadorPorEmail(email);
    }

    public boolean verificarExistenciaOrientadorId(Long id) {
        return cadastroOrientador.verificarExistenciaOrientadorId(id);
    }
    //Horarios


    public List<Horario> listarHorariosEstudantes() {
        return cadastroHorario.listarHorariosEstudantes();
    }


    public boolean verificarExistenciaHorario(Long id) {
        return cadastroHorario.verificarExistenciaHorario(id);
    }

    public Horario salvarHorario(Horario entity) throws HorarioDuplicadoException {
        return cadastroHorario.salvarHorario(entity);
    }

    public void atualizarHorario(Horario entity) throws HorarioNaoEncontradoException {
        cadastroHorario.atualizarHorario(entity);
    }

    public void excluirHorario(Long id) throws HorarioNaoEncontradoException {
        cadastroHorario.excluirHorario(id);
    }

    public boolean temConflito(Horario horarioNovo, Estudante estudante) {
        return cadastroHorario.temConflito(horarioNovo, estudante);
    }
    //VInculo


    public Vinculo cadastrarVinculo(Estudante estudante, Vinculo vinculo) {
        return cadastroVinculo.cadastrarVinculo(estudante, vinculo);
    }

    public void atualizarVinculo(Vinculo vinculo) {
        cadastroVinculo.atualizarVinculo(vinculo);
    }

    public boolean verificarExistenciaVinculo(Estudante estudante, TipoVinculo tipoVinculo, String dataInicio, String dataFim) {
        return cadastroVinculo.verificarExistenciaVinculo(estudante, tipoVinculo, dataInicio, dataFim);
    }

    //
}
