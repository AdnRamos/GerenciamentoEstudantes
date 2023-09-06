package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.*;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CadastroParticipacaoTest {

    @Autowired
    private CadastroParticipacao cadastroParticipacao;
    @Autowired
    private CadastroEstudante cadastroEstudante;
    @Autowired
    private CadastroProjeto cadastroProjeto;
    @Test
    public void SalvarParticipacaoTeste() throws ParticipacaoDuplicadaException, ParticipacaoDataInvalidaException, ParticipacaoAssociacaoException, ProjetoDuplicadoException, UsuarioDuplicadoException, ProjetoNaoExisteException {
        Estudante estudante = new Estudante(false, "galeroso", "@asuausdfn", "3452345235");
        Projeto projeto = new Projeto("Projeto asdfasdfa", "Descrição do Projeto", "2023-08-25",                "Java, Spring", "Aplicativo Web", "Sistema de Gerenciamento");


        Participacao participacao = new Participacao("15/07/23");
        participacao.setProjeto(projeto);
        participacao.setEstudante(estudante);
        cadastroProjeto.salvarProjeto(projeto);
        cadastroEstudante.salvarEstudante(estudante);
        cadastroParticipacao.cadastrarParticipacao(participacao);


        assertNotNull(participacao.getId());
    }

    @Test
    public void SalvarParticipacaoDuplicadaTeste() throws ParticipacaoDuplicadaException, UsuarioDuplicadoException, ProjetoDuplicadoException, ProjetoNaoExisteException {
        // Cenário
        Estudante estudante = new Estudante(false, "galeroso", "@3242342", "3452345235");
        Projeto projeto = new Projeto("Projeto ewerwerw", "Descrição do Projeto", "2023-08-25",                "Java, Spring", "Aplicativo Web", "Sistema de Gerenciamento");


        Participacao participacao = new Participacao("15/07/23");
        participacao.setProjeto(projeto);
        participacao.setEstudante(estudante);
        cadastroProjeto.salvarProjeto(projeto);
        cadastroEstudante.salvarEstudante(estudante);
        cadastroParticipacao.cadastrarParticipacao(participacao);

        // Ação e Verificação
        assertThrows(ParticipacaoDuplicadaException.class, () -> cadastroParticipacao.cadastrarParticipacao(participacao));
    }

    @Test
    public void ConsultarParticipacaoPorIdTeste() throws ParticipacaoNaoEncontradaException, ParticipacaoDuplicadaException, ProjetoNaoExisteException, ProjetoDuplicadoException {
        // Cenário
        Participacao participacao = new Participacao("2023-08-25");
        cadastroParticipacao.cadastrarParticipacao(participacao);

        // Ação
        Participacao resultado = cadastroParticipacao.consultarParticipacaoPorId(participacao.getId());

        // Verificação
        assertNotNull(resultado);
        assertEquals(participacao.getId(), resultado.getId());
    }

    @Test
    public void ConsultarParticipacaoPorIdNaoEncontradoTeste() {
        // Ação e Verificação
        assertThrows(ParticipacaoNaoEncontradaException.class, () -> cadastroParticipacao.consultarParticipacaoPorId(999L));
    }

}

