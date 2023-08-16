package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioNaoExisteException;

import java.util.List;

public interface InterfacePreCadastroEstudante {
    Estudante consultarEstudantePorId(Long id);
    Estudante consultarEstudantePorEmail(String email) throws UsuarioNaoExisteException;
    Estudante consultarEstudantePorNome(String nome) throws UsuarioNaoExisteException;
    Estudante consultarEstudantePorMatricula(String matricula) throws UsuarioNaoExisteException;

    List<Estudante> listarEstudantes();

    Estudante salvarEstudante(Estudante entity) throws UsuarioDuplicadoException;


    boolean verificarExistenciaEstudanteId(Long id);

    void removerUsuarioEmail(String email) throws UsuarioNaoExisteException;
}
