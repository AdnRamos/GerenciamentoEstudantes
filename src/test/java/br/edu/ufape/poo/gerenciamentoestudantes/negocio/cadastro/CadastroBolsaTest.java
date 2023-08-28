package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Bolsa;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.BolsaNaoEncontradaException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class CadastroBolsaTest {

    @Autowired
    private CadastroBolsa cadastroBolsa;

    @Test
    public void SalvarBolsaTeste() {
        Bolsa bolsa = new Bolsa("Descrição", "Edital", "Inicio", "Fim");
        cadastroBolsa.cadastrarBolsa(bolsa);

        assertNotNull(bolsa.getId()); // Certifica-se de que o ID foi gerado
    }

    @Test
    public void BuscarBolsaExistenteTeste() {
        Bolsa bolsa = new Bolsa("Descrição", "Edital", "Inicio", "Fim");
        cadastroBolsa.cadastrarBolsa(bolsa);

        Bolsa bolsaEncontrada = cadastroBolsa.buscarBolsaPorId(bolsa.getId());
        assertNotNull(bolsaEncontrada);
        assertEquals(bolsa.getId(), bolsaEncontrada.getId());
    }

    @Test
    public void BuscarBolsaNaoExistenteTeste() {
        assertThrows(BolsaNaoEncontradaException.class, () -> {
            cadastroBolsa.buscarBolsaPorId(9999L);
        });
    }

    @Test
    public void AtualizarBolsaExistenteTeste() {
        Bolsa bolsa = new Bolsa("Descrição", "Edital", "Inicio", "Fim");
        cadastroBolsa.cadastrarBolsa(bolsa);

        bolsa.setDescricao("Nova Descrição");
        cadastroBolsa.atualizarBolsa(bolsa);

        Bolsa bolsaAtualizada = cadastroBolsa.buscarBolsaPorId(bolsa.getId());
        assertEquals("Nova Descrição", bolsaAtualizada.getDescricao());
    }

    @Test
    public void DeletarBolsaTeste() {
        Bolsa bolsa = new Bolsa("Descrição", "Edital", "Inicio", "Fim");
        cadastroBolsa.cadastrarBolsa(bolsa);

        cadastroBolsa.deletarBolsa(bolsa.getId());

        assertThrows(BolsaNaoEncontradaException.class, () -> {
            cadastroBolsa.buscarBolsaPorId(bolsa.getId());
        });
    }
}
