package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioNaoExisteException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Orientador;
import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoOrientador;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CadastroOrientadorTest {

    @Autowired
    private CadastroOrientador cadastroOrientador;

    @MockBean
    private InterfaceColecaoOrientador colecaoOrientador;

    @Test
    public void SalvarOrientadorTeste() throws UsuarioDuplicadoException, UsuarioNaoExisteException {
        Orientador orientador = new Orientador(); // Crie um objeto Orientador para o teste
        when(colecaoOrientador.save(orientador)).thenReturn(orientador);

        cadastroOrientador.salvarOrientador(orientador);

        verify(colecaoOrientador, times(1)).save(orientador);
    }

    @Test
    public void ConsultarOrientadorPorEmailInexistenteTeste() {
        String emailInexistente = "email@inexistente.com";
        when(colecaoOrientador.findByEmail(emailInexistente)).thenReturn(null);

        assertThrows(UsuarioNaoExisteException.class, () -> {
            cadastroOrientador.consultarOrientadorPorEmail(emailInexistente);
        });
    }
    @Test
    public void VerificarExistenciaOrientadorIdTeste() {
        Long idExistente = 1L;
        when(colecaoOrientador.existsById(idExistente)).thenReturn(true);

        boolean existe = cadastroOrientador.verificarExistenciaOrientadorId(idExistente);

        assertTrue(existe);
    }
    @Test
    public void RemoverOrientadorPorEmailTeste() throws UsuarioNaoExisteException {
        long idParaRemover = 1L;
        Orientador orientador = new Orientador();
        when(colecaoOrientador.findById(idParaRemover)).thenReturn(Optional.of(orientador));

        cadastroOrientador.removerOrientadorId(idParaRemover);

        verify(colecaoOrientador, times(1)).delete(orientador);
    }
    @Test
    public void RemoverOrientadorPorEmailInexistenteTeste() {
        long idInexistente = 1L;
        when(colecaoOrientador.findById(idInexistente)).thenReturn(null);

        assertThrows(UsuarioNaoExisteException.class, () -> {
            cadastroOrientador.removerOrientadorId(idInexistente);
        });

        verify(colecaoOrientador, never()).delete(any());
    }



}

