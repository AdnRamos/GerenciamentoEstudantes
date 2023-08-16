package br.edu.ufape.poo.gerenciamentoestudantes.dados;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoInscricao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Inscricao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InterfaceColecaoInscricaoTeste {
    @Autowired
    private InterfaceColecaoInscricao ColecaoInscricao;

    @Test
    void cadastrarInscricao(){
        long qtdInscricao = ColecaoInscricao.count();
        Inscricao inscricao = new Inscricao();
        ColecaoInscricao.save(inscricao);
        long qtdInscricao1 = ColecaoInscricao.count();
        assertEquals(qtdInscricao+1,qtdInscricao1);
    }
}
