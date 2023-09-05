package br.edu.ufape.poo.gerenciamentoestudantes.negocio.fachada;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.*;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.TipoVinculo;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.*;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    @Autowired
    private InterfaceCadastrarRegistroAtividades cadastrarRegistroAtividades;
    @Autowired
    private InterfaceCadastroDocumento cadastroDocumento;
    @Autowired
    private InterfaceCadastroFuncao cadastroFuncao;
    @Autowired
    private InterfaceCadastroProjeto cadastroProjeto;
    @Autowired
    private InterfaceCadastroBolsa cadastroBolsa;
    @Autowired
    private InterfaceCadastroInscricao cadastroInscricao;
    @Autowired
    private InterfaceCadastroParticipacao cadastroParticipacao;
    @Autowired
    private InterfaceCadastroEndereco cadastroEndereco;


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
    public Estudante salvarEstudante(Estudante entity) throws UsuarioDuplicadoException {
        if(entity.getEndereco() != null){
            Endereco endereco = entity.getEndereco();
            cadastroEndereco.save(endereco);
        }
        return cadastroEstudante.salvarEstudante(entity);
    }
    public Estudante atualizarEstudante(Estudante estudanteAtualizado){
        return cadastroEstudante.atualizarEstudante(estudanteAtualizado);
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

    public Orientador atualizarOrientador(Orientador orientadorAtualizado) throws UsuarioNaoExisteException {
        return cadastroOrientador.atualizarOrientador(orientadorAtualizado);
    }

    public Orientador consultarOrientadorPorEmail(String email) throws UsuarioNaoExisteException {
        return cadastroOrientador.consultarOrientadorPorEmail(email);
    }

    public void removerOrientadorId(long id) throws UsuarioNaoExisteException {
        cadastroOrientador.removerOrientadorId(id);
    }

    public Orientador consultarOrientadorPorId(long id) throws UsuarioNaoExisteException {
        return cadastroOrientador.consultarOrientadorPorId(id);
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

    public Horario atualizarHorario(Horario entity) throws HorarioNaoEncontradoException {
        cadastroHorario.atualizarHorario(entity);
        return entity;
    }

    public void excluirHorario(Long id) throws HorarioNaoEncontradoException {
        cadastroHorario.excluirHorario(id);
    }




    /**
     public boolean temConflito(Horario horarioNovo, Estudante estudante) {
     return cadastroHorario.temConflito(horarioNovo, estudante);
     }
     */
    //Vinculo
    //preciso criar os metodos de listar

    public List<Vinculo> listarVinculosPorEstudante(Estudante estudante) {
        return cadastroVinculo.listarVinculosPorEstudante(estudante);
    }

    public Vinculo consultarVinculoPorId(Long id) {
        return cadastroVinculo.consultarPorId(id);
    }

    public List<Vinculo> listarVinculos() {
        return cadastroVinculo.listarVinculos();
    }

    public Vinculo cadastrarVinculo(Vinculo vinculo) throws UsuarioDuplicadoException {
        return cadastroVinculo.cadastrarVinculo(vinculo);
    }

    public Vinculo atualizarVinculo(Vinculo vinculo) {
        cadastroVinculo.atualizarVinculo(vinculo);
        return vinculo;
    }
    public void deletarVinculoPorId(Long aLong) {
        cadastroVinculo.deletarPorId(aLong);
    }

    public boolean verificarExistenciaVinculo(Estudante estudante, TipoVinculo tipoVinculo, String dataInicio, String dataFim) {
        return cadastroVinculo.verificarExistenciaVinculo(estudante, tipoVinculo, dataInicio, dataFim);
    }

    //Registro de Atividades

    public RegistroAtividade cadastrarRegistroAtividade(RegistroAtividade registroAtividade) throws HorarioDuplicadoException {
        return cadastrarRegistroAtividades.salvarRegistroAtividade(registroAtividade);
    }

    public RegistroAtividade buscarRegistroAtividadePorId(long id) {
        return cadastrarRegistroAtividades.buscarRegistroAtividadePorId(id);
    }

    public List<RegistroAtividade> buscarTodosRegistrosAtividade() {
        return cadastrarRegistroAtividades.buscarTodosRegistrosAtividade();
    }

    public RegistroAtividade atualizarRegistroAtividade(RegistroAtividade registroAtividade) throws RegistroAtividadeNaoEncontradoException, RegistroAtividadeDuplicadoException {
        return cadastrarRegistroAtividades.atualizarRegistroAtividade(registroAtividade);
    }

    public void excluirRegistroAtividade(long id) throws RegistroAtividadeNaoEncontradoException {
        cadastrarRegistroAtividades.excluirRegistroAtividade(id);
    }
    //Documentos

    public Documento salvarDocumento(Documento documento) throws DocumentoInvalidoException {
        return cadastroDocumento.salvarDocumento(documento);
    }

    public Documento buscarDocumentoPorId(long id) {
        return cadastroDocumento.buscarDocumentoPorId(id);
    }

    public List<Documento> listarDocumentos() {
        return cadastroDocumento.listarDocumentos();
    }

    public Documento atualizarDocumento(Documento documento) {
        return cadastroDocumento.atualizarDocumento(documento);
    }

    public void deletarDocumento(long id) {
        cadastroDocumento.deletarDocumento(id);
    }
    //Funca


    public Funcao cadastrarFuncao(Funcao funcao) throws FuncaoDuplicadaException {
        return cadastroFuncao.cadastrarFuncao(funcao);
    }

    public Funcao atualizarFuncao(Funcao funcao) {

        return cadastroFuncao.atualizarFuncao(funcao);
    }

    public void deletarFuncao(long id) {
        cadastroFuncao.deletarFuncao(id);
    }

    public Funcao buscarFuncaoPorId(long id) {
        return cadastroFuncao.buscarFuncaoPorId(id);
    }

    public List<Funcao> buscarFuncoesPorEstudante(Estudante estudante) {
        return cadastroFuncao.buscarFuncoesPorEstudante(estudante);
    }

    public void verificarFuncaoDuplicada(Estudante estudante, Funcao funcao) {
        cadastroFuncao.verificarFuncaoDuplicada(estudante, funcao);
    }
    public List<Funcao> listarFuncoes(){
        return cadastroFuncao.listarFuncoes();
    }
    //Bolsa

    public Bolsa cadastrarBolsa(Bolsa bolsa) throws BolsaDuplicadaException {
        return cadastroBolsa.cadastrarBolsa(bolsa);
    }

    public Bolsa buscarBolsaPorId(long id) {
        return cadastroBolsa.buscarBolsaPorId(id);
    }

    public List<Bolsa> listarBolsas() {
        return cadastroBolsa.listarBolsas();
    }

    public Bolsa atualizarBolsa(Bolsa bolsa) {

        return cadastroBolsa.atualizarBolsa(bolsa);
    }

    public void deletarBolsa(long id) {
        cadastroBolsa.deletarBolsa(id);
    }


    //Inscricoes

    public Inscricao cadastrarInscricao(Inscricao inscricao) throws InscricaoInvalidaException {
        return cadastroInscricao.cadastrarInscricao(inscricao);
    }

    public List<Inscricao> listarInscricoesPorEstudante(Estudante estudante) {
        return cadastroInscricao.listarInscricoesPorEstudante(estudante);
    }

    public List<Inscricao> listarInscricoes() {
        return cadastroInscricao.listarInscricoes();
    }

    public Inscricao buscarInscricaoPorId(long id) throws InscricaoNaoEncontradaException {
        return cadastroInscricao.buscarInscricaoPorId(id);
    }

    public void removerInscricaoPorId(long id) throws InscricaoNaoEncontradaException {
        cadastroInscricao.removerInscricaoPorId(id);
    }
    //participacao

    public Participacao cadastrarParticipacao(Participacao participacao) throws ParticipacaoDuplicadaException {
        return cadastroParticipacao.cadastrarParticipacao(participacao);
    }
    public void removerParticipacao(Participacao participacao) throws ParticipacaoNaoEncontradaException {
        cadastroParticipacao.removerParticipacao(participacao);
    }

    public Participacao consultarParticipacaoPorId(long id) throws ParticipacaoNaoEncontradaException {
        return cadastroParticipacao.consultarParticipacaoPorId(id);
    }

    public List<Participacao> listarParticipacoesPorEstudante(Estudante estudante) {
        return cadastroParticipacao.listarParticipacoesPorEstudante(estudante);
    }

    public List<Participacao> listarParticipacoesPorProjeto(Projeto projeto) {
        return cadastroParticipacao.listarParticipacoesPorProjeto(projeto);
    }
    // Endereço

    public List<Endereco> listarEnderecos() {
        return cadastroEndereco.findAll();
    }

    public <S extends Endereco> S salvarEndereco(S entity) {
        return cadastroEndereco.save(entity);
    }

    public Optional<Endereco> buscarEnderecoId(long id) {
        return cadastroEndereco.findById(id);
    }


    public void apagarEnderecoId(long id) {
        cadastroEndereco.deleteById(id);
    }
    //Projeto


    public List<Projeto> listarProjetos() {
        return cadastroProjeto.listarProjetos();
    }

    public Projeto salvarProjeto(Projeto projeto) throws ProjetoDuplicadoException, ProjetoNaoExisteException {
        return cadastroProjeto.salvarProjeto(projeto);
    }

    public void removerProjetoPorId(long id) throws ProjetoNaoExisteException {
        cadastroProjeto.removerProjetoPorId(id);
    }

    public Projeto consultarProjetoPorId(long id) throws ProjetoNaoExisteException {
        return cadastroProjeto.consultarProjetoPorId(id);
    }

    public boolean verificarExistenciaProjetoId(Long id) {
        return cadastroProjeto.verificarExistenciaProjetoId(id);
    }
}
