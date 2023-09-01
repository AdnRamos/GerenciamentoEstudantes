package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioNaoExisteException;

import java.util.List;

public interface InterfaceCadastroEstudante {

    //Crud
    List<Estudante> listarEstudantes();
    Estudante salvarEstudante(Estudante entity) throws UsuarioDuplicadoException;
    Estudante atualizarEstudante(Estudante estudanteAtualizado);
    void removerUsuarioEmail(String email) throws UsuarioNaoExisteException;

    //Verificar existência:
    boolean verificarExistenciaEstudanteId(Long id);

    //consultar por:
    Estudante consultarEstudantePorId(Long id);
    Estudante consultarEstudantePorEmail(String email) throws UsuarioNaoExisteException;
    Estudante consultarEstudantePorNome(String nome) throws UsuarioNaoExisteException;
    Estudante consultarEstudantePorMatricula(String matricula) throws UsuarioNaoExisteException;
}
