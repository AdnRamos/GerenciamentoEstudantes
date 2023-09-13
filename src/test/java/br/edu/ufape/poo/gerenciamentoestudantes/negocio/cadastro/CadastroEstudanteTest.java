package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioNaoExisteException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CadastroEstudanteTest {
    @Autowired
    private InterfaceCadastroEstudante cadastroEstudante;
    @Test
    void cadastroEstudanteTeste(){
        String email = "jose@gmail.com";
        Estudante e0 = new Estudante(true, "jose", email, "5544552");
        Estudante e = new Estudante(true, "jose", email, "5544552");

        UsuarioDuplicadoException exception = assertThrows(UsuarioDuplicadoException.class,()->{
             cadastroEstudante.salvarEstudante(e0);
             cadastroEstudante.salvarEstudante(e);
        });
        assertEquals(exception.getEmail(),email);
        assertTrue(exception.getMessage().contains("mesmo email"));


    }
    @Test
    public void testSalvarEstudante() throws UsuarioDuplicadoException {
        Estudante estudante = new Estudante(true, "carlos", "carlos@gmail.com", "5544552");
        Estudante savedEstudante = cadastroEstudante.salvarEstudante(estudante);

        assertNotNull(savedEstudante.getId());
    }

    @Test
    public void testSalvarEstudanteDuplicado() throws UsuarioDuplicadoException {
        Estudante estudante = new Estudante(false, "victor", "victor@gmail.com", "5544553");
        cadastroEstudante.salvarEstudante(estudante);

        assertThrows(UsuarioDuplicadoException.class, () -> {
            cadastroEstudante.salvarEstudante(estudante);
        });
    }

    @Test
    public void testConsultarEstudantePorId() throws UsuarioDuplicadoException {
        Estudante estudante = new Estudante(true, "joao", "joao@gmail.com", "5544554");
        Estudante savedEstudante = cadastroEstudante.salvarEstudante(estudante);

        Estudante foundEstudante = cadastroEstudante.consultarEstudantePorId(savedEstudante.getId());
        assertNotNull(foundEstudante);
        assertEquals(savedEstudante.getId(), foundEstudante.getId());
    }


    @Test
    public void testConsultarEstudantePorEmail() throws UsuarioNaoExisteException, UsuarioDuplicadoException {
        Estudante estudante = new Estudante(true, "jean", "as123121251515dfasdewefasdfasf", "5544552");
        cadastroEstudante.salvarEstudante(estudante);

        Estudante foundEstudante = cadastroEstudante.consultarEstudantePorEmail("as123121251515dfasdewefasdfasf");
        assertNotNull(foundEstudante);
        assertEquals("as123121251515dfasdewefasdfasf", foundEstudante.getEmail());
    }

    @Test
    public void testConsultarEstudantePorMatricula() throws UsuarioDuplicadoException, UsuarioNaoExisteException {
        Estudante estudante = new Estudante(true, "kmkm", "as123dfasdewef0122asdfasf", "554455211");
        cadastroEstudante.salvarEstudante(estudante);

        Estudante foundEstudante = cadastroEstudante.consultarEstudantePorMatricula("554455211");
        assertNotNull(foundEstudante);
        assertEquals("554455211", foundEstudante.getMatricula());
    }

    @Test
    public void testRemoverUsuarioEmail() throws UsuarioNaoExisteException, UsuarioDuplicadoException {
        Estudante estudante = new Estudante(true, "jean", "as123dfas324dewefasdfasf", "5544552");
        Estudante savedEstudante = cadastroEstudante.salvarEstudante(estudante);

        cadastroEstudante.removerUsuarioEmail(savedEstudante.getEmail());

        assertThrows(UsuarioNaoExisteException.class, () -> {
            cadastroEstudante.consultarEstudantePorEmail(savedEstudante.getEmail());
        });
    }
}
