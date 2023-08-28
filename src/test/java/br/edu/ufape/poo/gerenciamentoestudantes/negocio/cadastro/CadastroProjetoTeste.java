package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoProjeto;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Projeto;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.ProjetoDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.ProjetoNaoExisteException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CadastroProjetoTeste {

    @Autowired
    private CadastroProjeto cadastroProjeto;

    @Test
    public void testSalvarProjeto() throws ProjetoDuplicadoException, ProjetoNaoExisteException {
        Projeto projeto = new Projeto("Projeto Teste", "Descrição do Projeto", "2023-08-25",
                "Java, Spring", "Aplicativo Web", "Sistema de Gerenciamento");

        Projeto savedProjeto = cadastroProjeto.salvarProjeto(projeto);
        assertNotNull(savedProjeto.getId());

        Projeto retrievedProjeto = cadastroProjeto.consultarProjetoPorNome("Projeto Teste");
        assertEquals(savedProjeto.getId(), retrievedProjeto.getId());
    }

    @Test
    public void testSalvarProjetoDuplicado() throws ProjetoDuplicadoException {
        Projeto projeto = new Projeto("Projeto Duplicado", "Descrição do Projeto", "2023-08-25",
                "Java, Spring", "Aplicativo Web", "Sistema de Gerenciamento");
        cadastroProjeto.salvarProjeto(projeto);
        assertThrows(ProjetoDuplicadoException.class, () -> {
            // Seu código que deve lançar ProjetoDuplicadoException
            cadastroProjeto.salvarProjeto(projeto);
        });    }

    @Test
    public void testRemoverProjetoPorNome() throws ProjetoNaoExisteException {
        Projeto projeto = cadastroProjeto.consultarProjetoPorNome("Projeto Teste");
        cadastroProjeto.removerProjetoPorNome(projeto.getNomeProjeto());

        assertThrows(ProjetoNaoExisteException.class, () -> cadastroProjeto.consultarProjetoPorNome("Projeto Teste"));
    }

    @Test
    public void testConsultarProjetoPorNome() {
        assertThrows(ProjetoNaoExisteException.class, () -> cadastroProjeto.consultarProjetoPorNome("Projeto Inexistente"));
    }
}
