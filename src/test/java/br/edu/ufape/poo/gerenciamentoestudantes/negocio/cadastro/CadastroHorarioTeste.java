package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.DiaSemana;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Horario;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.HorarioDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.HorarioExisteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CadastroHorarioTeste {

    @Autowired
    private InterfaceCadastroHorario cadastroHorario;

    @BeforeEach
    public void setUp() {

     }

    @Test
    public void testSalvarHorario() throws HorarioDuplicadoException {
        Horario horario = new Horario();
        horario.setDiaSemana(DiaSemana.SEGUNDA);
        horario.setHoraInicio("08:00");
        horario.setHoraFim("10:00");

        Horario horarioSalvo = cadastroHorario.salvarHorario(horario);

        assertNotNull(horarioSalvo);
        assertNotNull(horarioSalvo.getId()); // Certificar-se de que o ID foi gerado
        assertEquals(DiaSemana.SEGUNDA, horarioSalvo.getDiaSemana());
        assertEquals("08:00", horarioSalvo.getHoraInicio());
        assertEquals("10:00", horarioSalvo.getHoraFim());
        // Outras verificações, se necessário
    }

}