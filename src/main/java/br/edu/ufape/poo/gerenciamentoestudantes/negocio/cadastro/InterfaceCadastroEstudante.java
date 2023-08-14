package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioNaoExisteException;

import java.util.List;

public interface InterfaceCadastroEstudante {
    Estudante procurarEstudanteEmail(String email) throws UsuarioNaoExisteException;

    List<Estudante> listarEstudantes();

    Estudante salvarEstudante(Estudante entity) throws UsuarioDuplicadoException;

    Estudante buscarEstudanteId(Long id);

    boolean verificarExistenciaEstudanteId(Long id);

    void removerUsuarioEmail(String email) throws UsuarioNaoExisteException;
}
