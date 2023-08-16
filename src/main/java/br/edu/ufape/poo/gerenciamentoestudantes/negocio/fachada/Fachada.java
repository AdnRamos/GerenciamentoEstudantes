package br.edu.ufape.poo.gerenciamentoestudantes.negocio.fachada;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.InterfacePreCadastroEstudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioNaoExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Fachada {
    @Autowired
    private InterfacePreCadastroEstudante cadastroEstudante;
    //Consultar por:
    public Estudante consultarEstudanteEmail(String email) throws UsuarioNaoExisteException {
        return cadastroEstudante.consultarEstudantePorEmail(email);
    }
    public Estudante procurarEstudanteId(Long id) {
        return cadastroEstudante.consultarEstudantePorId(id);
    }
    //Listar Todos
    public List<Estudante> listarEstudantes() {
        return cadastroEstudante.listarEstudantes();
    }
    //Verificar existencia
    public boolean verificarExistenciaEstudanteId(Long id) {
        return cadastroEstudante.verificarExistenciaEstudanteId(id);
    }
    public Estudante salvarEstudante(Estudante entity) throws UsuarioDuplicadoException {
        return cadastroEstudante.salvarEstudante(entity);
    }

    public void removerUsuarioEmail(String email) throws UsuarioNaoExisteException {
        cadastroEstudante.removerUsuarioEmail(email);
    }
}
