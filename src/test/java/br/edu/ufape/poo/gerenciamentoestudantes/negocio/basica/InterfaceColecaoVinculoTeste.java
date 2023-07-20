package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoVinculo;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enum.TipoVinculo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InterfaceColecaoVinculoTeste {
    @Autowired
    private InterfaceColecaoVinculo ColecaoVinculo;
    @Test
    void CadastrarVinculoTeste(){
        long qtdVinculo = ColecaoVinculo.count();
        Vinculo vinculo = new Vinculo(TipoVinculo.BOLSISTA, "20", "20/08/2022");

        ColecaoVinculo.save(vinculo);
        long qtdVinculo1 = ColecaoVinculo.count();
        assertEquals(qtdVinculo+1, qtdVinculo1);

    }
}
