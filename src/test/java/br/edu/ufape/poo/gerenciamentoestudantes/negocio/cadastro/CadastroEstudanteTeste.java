package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CadastroEstudanteTeste {
    @Autowired
    private InterfaceCadastroEstudante cadastroEstudante;
    @Test
    void cadastroEstudanteTeste(){
        String email = "Naoseimais@desgraçaaaaa.com";
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
    @Disabled("Teste Criado para dar erro!")
    void cadastroEstudanteDuplicado(){
        //Teste 2 - inventando moda
        // Criar um estudante para cadastro
        Estudante estudante = new Estudante(/* Parâmetros do construtor */);

        // Executar o cadastro do estudante
        assertDoesNotThrow(() -> {
            cadastroEstudante.salvarEstudante(estudante);
        }, "Erro ao cadastrar estudante");

        // Tentar cadastrar o mesmo estudante novamente (deve lançar a exceção UsuarioDuplicadoException)
        assertThrows(UsuarioDuplicadoException.class, () -> {
            cadastroEstudante.salvarEstudante(estudante);
        }, "Usuário duplicado não lançou exceção como esperado");
    }
}
