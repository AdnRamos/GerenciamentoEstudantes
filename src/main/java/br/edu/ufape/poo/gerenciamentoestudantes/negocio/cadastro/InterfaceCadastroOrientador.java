package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Orientador;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioNaoExisteException;

import java.util.List;

public interface InterfaceCadastroOrientador {
    //CRUD
    List<Orientador> listarOrientadores();

    Orientador salvarOrientador(Orientador entity) throws UsuarioDuplicadoException;
    Orientador atualizarOrientador(Orientador orientadorAtualizado) throws UsuarioNaoExisteException;

    void removerOrientadorId(long id) throws UsuarioNaoExisteException;
    Orientador consultarOrientadorPorId(long id) throws  UsuarioNaoExisteException;
    //Consultar
    Orientador consultarOrientadorPorEmail(String email) throws UsuarioNaoExisteException;

    //Existencia
    boolean verificarExistenciaOrientadorId(Long id);
}
