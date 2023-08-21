package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoOrientador;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Orientador;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioNaoExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroOrientador implements InterfaceCadastroOrientador {
    @Autowired
    private InterfaceColecaoOrientador colecaoOrientador;

    //CRUD
    @Override
    public List<Orientador> listarOrientadores(){
        return colecaoOrientador.findAll();
    }
    @Override
    public Orientador salvarOrientador(Orientador entity) throws UsuarioDuplicadoException {
        try{
            consultarOrientadorPorEmail(entity.getEmail());
            throw new UsuarioDuplicadoException(entity.getEmail());
        }catch (UsuarioNaoExisteException err){
            return colecaoOrientador.save(entity);
        }
    }
    @Override
    public void removerUsuarioEmail(String email) throws UsuarioNaoExisteException {
        Orientador o = consultarOrientadorPorEmail(email);
        colecaoOrientador.delete(o);

    }
    //Consultar
    @Override
    public Orientador consultarOrientadorPorEmail(String email) throws UsuarioNaoExisteException {
        Orientador o = colecaoOrientador.findByEmail(email);
        if(o == null){
            throw new UsuarioNaoExisteException(email);
        }
        return o;
    }
    //Existencia
    @Override
    public boolean verificarExistenciaOrientadorId(Long id) {
        return colecaoOrientador.existsById(id);
    }

}

