package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Projeto;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.ProjetoDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.ProjetoNaoExisteException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CadastroProjetoTest {

    @Autowired
    private CadastroProjeto cadastroProjeto;

    @Test
    public void SalvarProjetoTeste() throws ProjetoDuplicadoException, ProjetoNaoExisteException {
        Projeto projeto = new Projeto("Projeto Teste2", "Descrição do Projeto", "2023-08-25",
                "Java, Spring", "Aplicativo Web", "Sistema de Gerenciamento");

        Projeto projetoSalvo = cadastroProjeto.salvarProjeto(projeto);
        assertNotNull(projetoSalvo.getId());

        Projeto consultarProjetoSalvo = cadastroProjeto.consultarProjetoPorId(projetoSalvo.getId());
        assertEquals(projetoSalvo.getId(), consultarProjetoSalvo.getId());
    }

    @Test
    public void SalvarProjetoDuplicadoTeste() throws ProjetoDuplicadoException, ProjetoNaoExisteException {
        Projeto projeto = new Projeto("Projeto Duplicado", "Descrição do Projeto", "2023-08-25",
                "Java, Spring", "Aplicativo Web", "Sistema de Gerenciamento");
        cadastroProjeto.salvarProjeto(projeto);
        assertThrows(ProjetoDuplicadoException.class, () -> {
            // Seu código que deve lançar ProjetoDuplicadoException
            cadastroProjeto.salvarProjeto(projeto);
        });    }

    @Test
    public void RemoverProjetoPorNomeTeste() throws ProjetoNaoExisteException, ProjetoDuplicadoException {
        Projeto removerTeste = new Projeto("Projeto remover", "Descrição do Projeto", "2023-08-25",
                "Java, Spring", "Aplicativo Web", "Sistema de Gerenciamento");
        cadastroProjeto.salvarProjeto(removerTeste);
        Projeto projeto = cadastroProjeto.consultarProjetoPorId(removerTeste.getId());
        cadastroProjeto.removerProjetoPorId(projeto.getId());

        assertThrows(ProjetoNaoExisteException.class, () -> cadastroProjeto.consultarProjetoPorId(projeto.getId()));
    }


}
