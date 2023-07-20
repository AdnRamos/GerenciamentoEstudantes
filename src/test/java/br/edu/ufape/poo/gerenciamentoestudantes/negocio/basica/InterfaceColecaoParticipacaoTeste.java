package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoParticipacao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InterfaceColecaoParticipacaoTeste {
    @Autowired
    private InterfaceColecaoParticipacao ColecaoParticipacao;

    @Test
    void cadastrarParticipacaoTeste(){
        long qtdParticipacao = ColecaoParticipacao.count();
        Participacao part = new Participacao("30/10/2006");
        ColecaoParticipacao.save(part);
        long qtdParticipacao1 = ColecaoParticipacao.count();
        assertEquals(qtdParticipacao+1, qtdParticipacao1);
    }
}
