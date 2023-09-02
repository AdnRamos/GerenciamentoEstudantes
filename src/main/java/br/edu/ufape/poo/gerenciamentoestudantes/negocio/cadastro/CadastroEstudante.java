package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoEndereco;
import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoEstudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Endereco;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioNaoExisteException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroEstudante implements InterfaceCadastroEstudante {
    @Autowired
    private InterfaceColecaoEstudante colecaoEstudante;
    @Autowired
    private InterfaceColecaoEndereco colecaoEndereco;

    //CRUD
    @Override
    public List<Estudante> listarEstudantes() {
        return colecaoEstudante.findAll();
    }

    @Override
    public Estudante salvarEstudante( Estudante entity) throws UsuarioDuplicadoException {
        try{
            consultarEstudantePorEmail(entity.getEmail());
            throw new UsuarioDuplicadoException(entity.getEmail());
        }catch (UsuarioNaoExisteException err){
            if(entity.getEndereco() != null){
                Endereco endereco = entity.getEndereco();
                colecaoEndereco.save(endereco);
            }

            return colecaoEstudante.save(entity);
        }
    }
    @Override
    public Estudante atualizarEstudante(Estudante estudanteAtualizado){
        Estudante estudanteExistente = consultarEstudantePorId(estudanteAtualizado.getId());

        // Atualizar apenas os campos fornecidos
        if (estudanteAtualizado.getNome() != null) {
            estudanteExistente.setNome(estudanteAtualizado.getNome());
        }
        if (estudanteAtualizado.getEmail() != null) {
            estudanteExistente.setEmail(estudanteAtualizado.getEmail());
        }
        if (estudanteAtualizado.getCurso() != null) {
            estudanteExistente.setCurso(estudanteAtualizado.getCurso());
        }
        if (estudanteAtualizado.getCelular() != null) {
            estudanteExistente.setCelular(estudanteAtualizado.getCelular());
        }
        if (estudanteAtualizado.getNumeroRg() != null) {
            estudanteExistente.setNumeroRg(estudanteAtualizado.getNumeroRg());
        }
        if (estudanteAtualizado.getOrgaoExpedidor() != null) {
            estudanteExistente.setOrgaoExpedidor(estudanteAtualizado.getOrgaoExpedidor());
        }
        if (estudanteAtualizado.getDataEmissao() != null) {
            estudanteExistente.setDataEmissao(estudanteAtualizado.getDataEmissao());
        }
        if (estudanteAtualizado.getCpf() != null) {
            estudanteExistente.setCpf(estudanteAtualizado.getCpf());
        }
        if (estudanteAtualizado.getEstadoCivil() != null) {
            estudanteExistente.setEstadoCivil(estudanteAtualizado.getEstadoCivil());
        }
        if (estudanteAtualizado.getNacionalidade() != null) {
            estudanteExistente.setNacionalidade(estudanteAtualizado.getNacionalidade());
        }
        if (estudanteAtualizado.getNaturalidade() != null) {
            estudanteExistente.setNaturalidade(estudanteAtualizado.getNaturalidade());
        }
        if (estudanteAtualizado.getMatricula() != null) {
            estudanteExistente.setMatricula(estudanteAtualizado.getMatricula());
        }
        // Continue para outros campos que podem ser atualizados

        // Salvar o estudante atualizado no repositório
        return colecaoEstudante.save(estudanteExistente);


    }

    @Override
    public void removerUsuarioEmail(String email) throws UsuarioNaoExisteException {
        Estudante e = consultarEstudantePorEmail(email);
        colecaoEstudante.delete(e);
    }
    //Consultar por:
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
        Estudante e = colecaoEstudante.findByMatricula(matricula); // Usar findByMatricula aqui
        if (e == null) {
            throw new UsuarioNaoExisteException(matricula);
        }
        return e;
    }


    //Verificar existencia
    @Override
    public boolean verificarExistenciaEstudanteId(Long id) {

        return colecaoEstudante.existsById(id);
    }

}
