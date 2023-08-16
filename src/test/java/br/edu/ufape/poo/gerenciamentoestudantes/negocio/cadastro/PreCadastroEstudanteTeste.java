package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PreCadastroEstudanteTeste {
    @Autowired
    private InterfacePreCadastroEstudante cadastroEstudante;
    @Test
    void cadastroEmailDuplicadoTeste(){
        String email = "Naoseimais@oquetaacontecendo.com";
        Estudante e0 = new Estudante(true, "carlos", email, "5544552");
        Estudante e1 = new Estudante(true, "carlos", email, "5544552");
        UsuarioDuplicadoException exception = assertThrows(UsuarioDuplicadoException.class,()->{
           cadastroEstudante.salvarEstudante(e0);
           cadastroEstudante.salvarEstudante(e1);
        });
        assertEquals(exception.getEmail(),email);
        assertTrue(exception.getMessage().contains("mesmo email"));
    }
}
