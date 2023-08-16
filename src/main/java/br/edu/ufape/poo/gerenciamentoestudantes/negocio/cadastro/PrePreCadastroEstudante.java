package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoEstudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioNaoExisteException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrePreCadastroEstudante implements InterfacePreCadastroEstudante {
    @Autowired
    private InterfaceColecaoEstudante colecaoEstudante;

    @Override
    public Estudante consultarEstudantePorId(Long id) {
        return colecaoEstudante.findById(id).orElse(null);
    }

    @Override
    public Estudante consultarEstudantePorNome(String nome) throws UsuarioNaoExisteException {
        Estudante e = colecaoEstudante.findByNome(nome);
        if(e == null){
            throw new UsuarioNaoExisteException(nome);
        }
        return e;
    }
    @Override
    public Estudante consultarEstudantePorEmail(String email) throws UsuarioNaoExisteException {
        Estudante e = colecaoEstudante.findByEmail(email);
        if(e == null){
            throw new UsuarioNaoExisteException(email);
        }
        return e;
    }
    @Override
    public Estudante consultarEstudantePorMatricula(String matricula) throws UsuarioNaoExisteException {
        Estudante e = colecaoEstudante.findByEmail(matricula);
        if(e == null){
            throw new UsuarioNaoExisteException(matricula);
        }
        return e;
    }


    @Override
    public List<Estudante> listarEstudantes() {
        return colecaoEstudante.findAll();
    }

    @Override
    public Estudante salvarEstudante(Estudante entity) throws UsuarioDuplicadoException {
        try{
            consultarEstudantePorEmail(entity.getEmail());
            throw new UsuarioDuplicadoException(entity.getEmail());
        }catch (UsuarioNaoExisteException err){
            return colecaoEstudante.save(entity);
        }
    }



    @Override
    public boolean verificarExistenciaEstudanteId(Long id) {
        return colecaoEstudante.existsById(id);
    }

    @Override
    public void removerUsuarioEmail(String email) throws UsuarioNaoExisteException {
        Estudante e = consultarEstudantePorEmail(email);
        colecaoEstudante.delete(e);
    }
}
