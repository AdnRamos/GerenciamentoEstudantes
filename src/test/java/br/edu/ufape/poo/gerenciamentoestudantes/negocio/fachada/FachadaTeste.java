package br.edu.ufape.poo.gerenciamentoestudantes.negocio.fachada;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FachadaTeste {
    @Autowired
    private Fachada fachada;

    @BeforeEach
    public void init() throws UsuarioDuplicadoException{
        Estudante e = new Estudante(true, "carlos", "carlos@gmail.com", "5544552");

        fachada.salvarEstudante(e);


    }
    @Test
    void atuailzarEstudante() {
        Estudante e = fachada.procurarEstudanteId(1L);
        Estudante temp = e;
        e.setEmail("jojo@ufape.edu.br");
        e.setNome("Jojo");
        e.setGestao(false);
        fachada.procurarEstudanteId(1L);

        assertEquals(e.getEmail(), temp.getEmail());
    }

}
