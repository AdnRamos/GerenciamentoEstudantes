package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoOrientador;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
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
    public Orientador atualizarOrientador(Orientador orientadorAtualizado) throws  UsuarioNaoExisteException {
        Orientador orientadorExistente = consultarOrientadorPorId(orientadorAtualizado.getId());

        // Atualizar apenas os campos fornecidos
        if (orientadorAtualizado.getNome() != null) {
            orientadorExistente.setNome(orientadorAtualizado.getNome());
        }
        if (orientadorAtualizado.getEmail() != null) {
            orientadorExistente.setEmail(orientadorAtualizado.getEmail());
        }
        if (orientadorAtualizado.getCurso() != null) {
            orientadorExistente.setCurso(orientadorAtualizado.getCurso());
        }
        if (orientadorAtualizado.getCelular() != null) {
            orientadorExistente.setCelular(orientadorAtualizado.getCelular());
        }
        if (orientadorAtualizado.getNumeroRg() != null) {
            orientadorExistente.setNumeroRg(orientadorAtualizado.getNumeroRg());
        }
        if (orientadorAtualizado.getOrgaoExpedidor() != null) {
            orientadorExistente.setOrgaoExpedidor(orientadorAtualizado.getOrgaoExpedidor());
        }
        if (orientadorAtualizado.getDataEmissao() != null) {
            orientadorExistente.setDataEmissao(orientadorAtualizado.getDataEmissao());
        }
        if (orientadorAtualizado.getCpf() != null) {
            orientadorExistente.setCpf(orientadorAtualizado.getCpf());
        }
        if (orientadorAtualizado.getEstadoCivil() != null) {
            orientadorExistente.setEstadoCivil(orientadorAtualizado.getEstadoCivil());
        }
        if (orientadorAtualizado.getNacionalidade() != null) {
            orientadorExistente.setNacionalidade(orientadorAtualizado.getNacionalidade());
        }
        if (orientadorAtualizado.getNaturalidade() != null) {
            orientadorExistente.setNaturalidade(orientadorAtualizado.getNaturalidade());
        }
        if (orientadorAtualizado.getEspecialidade() != null) {
            orientadorExistente.setEspecialidade(orientadorAtualizado.getEspecialidade());
        }
        return colecaoOrientador.save(orientadorAtualizado);
    }
    @Override
    public void removerOrientadorId(long id) throws UsuarioNaoExisteException {
        Orientador o = consultarOrientadorPorId(id);
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
    @Override
    public Orientador consultarOrientadorPorId(long id) throws UsuarioNaoExisteException {
        return colecaoOrientador.findById(id).orElseThrow(() -> new UsuarioNaoExisteException(id));
    }
    //Existencia
    @Override
    public boolean verificarExistenciaOrientadorId(Long id) {
        return colecaoOrientador.existsById(id);
    }

}

