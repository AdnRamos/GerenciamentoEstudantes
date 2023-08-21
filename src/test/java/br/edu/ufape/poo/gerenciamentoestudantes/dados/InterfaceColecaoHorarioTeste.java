package br.edu.ufape.poo.gerenciamentoestudantes.dados;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.DiaSemana;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.ModalidadeAtividade;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Horario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InterfaceColecaoHorarioTeste {
    @Autowired
    private InterfaceColecaoHorario ColecaoHorarios;

    @Test
    void cadastrarHorarioTeste(){
        long qtdHorarios = ColecaoHorarios.count();
        Horario h1 = new Horario(ModalidadeAtividade.PRESENCIAL, DiaSemana.SEGUNDA,"14:00", "17:00");
        ColecaoHorarios.save(h1);
        long qtdHorarios1 = ColecaoHorarios.count();
        assertEquals(qtdHorarios+1, qtdHorarios1);

    }
}
