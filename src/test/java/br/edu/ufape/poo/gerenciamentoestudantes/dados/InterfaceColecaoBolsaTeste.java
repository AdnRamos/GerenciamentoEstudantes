package br.edu.ufape.poo.gerenciamentoestudantes.dados;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoBolsa;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Bolsa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InterfaceColecaoBolsaTeste {
    @Autowired
    private InterfaceColecaoBolsa ColecaoBolsa;

    @Test
    void cadastrarBolsa(){
        long qtdBolsas = ColecaoBolsa.count();
        Bolsa b =  new Bolsa("se fudeo", "vai ganhar money", "12/12/22", "15/01/23");
        ColecaoBolsa.save(b);
        long qtdBolsas1 = ColecaoBolsa.count();
        assertEquals(qtdBolsas+1,qtdBolsas1);
    }

}
