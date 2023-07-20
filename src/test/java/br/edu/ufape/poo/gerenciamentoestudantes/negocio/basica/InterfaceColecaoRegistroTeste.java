package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoRegistro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InterfaceColecaoRegistroTeste {
    @Autowired
    private InterfaceColecaoRegistro ColecaoRegistro;

    @Test
    void cadastrarRegistroTeste(){
        long qtdRegistro = ColecaoRegistro.count();

        RegistroAtividade reg = new RegistroAtividade("fiz nada nessa desgraca nao");

        ColecaoRegistro.save(reg);
        long qtdRegistro1 = ColecaoRegistro.count();

        assertEquals(qtdRegistro+1, qtdRegistro1);

    }
}
