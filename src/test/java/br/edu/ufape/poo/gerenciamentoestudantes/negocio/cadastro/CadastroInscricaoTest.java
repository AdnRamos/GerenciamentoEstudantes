package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Bolsa;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Inscricao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.InscricaoDuplicadaException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.InscricaoNaoEncontradaException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CadastroInscricaoTest {

    @Autowired
    private CadastroInscricao cadastroInscricao;
    @Autowired
    private CadastroBolsa cadastroBolsa;
    @Autowired
    private CadastroEstudante cadastroEstudante;




    @Test
    public void CadastrarInscricaoTeste() throws UsuarioDuplicadoException {
        Estudante estudante = new Estudante(false, "galeroso", "@asdfasdvaaawsdabrh", "3452345235");

        Bolsa bolsa = new Bolsa("Descrição2c242 da Bolsa", "Edital 2023", "01/08/2023", "31/08/2023");

        Inscricao inscricao = new Inscricao(bolsa, estudante);

        cadastroBolsa.cadastrarBolsa(bolsa);
        cadastroEstudante.salvarEstudante(estudante);

        cadastroInscricao.cadastrarInscricao(inscricao);
        assertNotNull(inscricao.getId());
    }

    @Test
    public void BuscarInscricaoPorIdTeste() throws UsuarioDuplicadoException {
        Estudante estudante = new Estudante(false, "galeroso", "@asuwerwrwausdfn", "3452345235");
        cadastroEstudante.salvarEstudante(estudante);

        Bolsa bolsa = new Bolsa("Descrição sd sd da Bolsa", "Edital 2023", "01/08/2023", "31/08/2023");
        cadastroBolsa.cadastrarBolsa(bolsa);

        Inscricao inscricao = new Inscricao(bolsa, estudante);
        cadastroInscricao.cadastrarInscricao(inscricao);

        long id = inscricao.getId();

        Inscricao inscricaoEncontrada = cadastroInscricao.buscarInscricaoPorId(id);

        assertNotNull(inscricaoEncontrada);
        assertEquals(id, inscricaoEncontrada.getId());
    }

    @Test
    public void BuscarInscricaoPorIdInexistenteTeste() {
        long idInexistente = 9999L;
        assertThrows(InscricaoNaoEncontradaException.class, () -> {
            cadastroInscricao.buscarInscricaoPorId(idInexistente);
        });
    }

    @Test
    public void ListarInscricoesTeste() throws UsuarioDuplicadoException {
        Estudante estudante = new Estudante(false, "galeroso", "@24234234", "3452345235");
        Estudante estudante1 = new Estudante(false, "galeroso", "@efasdfa", "3452345235");
        cadastroEstudante.salvarEstudante(estudante);
        cadastroEstudante.salvarEstudante(estudante1);

        Bolsa bolsa = new Bolsa("324234234234 da Bolsa", "Edital 2023", "01/08/2023", "31/08/2023");
        cadastroBolsa.cadastrarBolsa(bolsa);

        Inscricao inscricao = new Inscricao(bolsa, estudante);
        cadastroInscricao.cadastrarInscricao(inscricao);
        Inscricao inscricao1 = new Inscricao(bolsa, estudante1);
        cadastroInscricao.cadastrarInscricao(inscricao1);
        List<Inscricao> inscricoes = cadastroInscricao.listarInscricoes();

        assertFalse(inscricoes.isEmpty());
    }

    @Test
    public void DeletarInscricaoTeste() throws UsuarioDuplicadoException {
        Estudante estudante = new Estudante(false, "galeroso", "@werqwerqw", "3452345235");
        cadastroEstudante.salvarEstudante(estudante);

        Bolsa bolsa = new Bolsa("Descrição da Bolsa1", "Edital 2023", "01/08/2023", "31/08/2023");
        cadastroBolsa.cadastrarBolsa(bolsa);

        Inscricao inscricao = new Inscricao(bolsa, estudante);
        cadastroInscricao.cadastrarInscricao(inscricao);
        cadastroInscricao.removerInscricaoPorId(inscricao.getId());

        assertThrows(InscricaoNaoEncontradaException.class, () -> {
            cadastroInscricao.buscarInscricaoPorId(inscricao.getId());
        });
    }

    @Test
    public void CadastrarInscricaoDuplicadaTeste() throws UsuarioDuplicadoException {
        Estudante estudante = new Estudante(false, "galeroso", "@tehthrt", "3452345235");
        cadastroEstudante.salvarEstudante(estudante);

        Bolsa bolsa = new Bolsa("Descrição da Bolsa", "Edital 2023", "01/08/2023", "31/08/2023");
        cadastroBolsa.cadastrarBolsa(bolsa);

        Inscricao inscricao = new Inscricao(bolsa, estudante);
        cadastroInscricao.cadastrarInscricao(inscricao);
        assertThrows(InscricaoDuplicadaException.class, () -> {
            cadastroInscricao.cadastrarInscricao(inscricao);
        });
    }
}