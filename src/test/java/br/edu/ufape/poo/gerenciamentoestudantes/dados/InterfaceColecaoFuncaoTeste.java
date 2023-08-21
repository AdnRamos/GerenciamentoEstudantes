package br.edu.ufape.poo.gerenciamentoestudantes.dados;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.TipoFuncao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Funcao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InterfaceColecaoFuncaoTeste {
    @Autowired
    private InterfaceColecaoFuncao ColecaoFuncao;

    @Test
    void cadastrarVinculoTeste(){
        long qtdVinculo = ColecaoFuncao.count();
        Funcao funcao = new Funcao(TipoFuncao.DESIGNER, "30/12/2002");
        ColecaoFuncao.save(funcao);
        long qtdVinculo1 = ColecaoFuncao.count();
        assertEquals(qtdVinculo+1,qtdVinculo1);
    }
}
