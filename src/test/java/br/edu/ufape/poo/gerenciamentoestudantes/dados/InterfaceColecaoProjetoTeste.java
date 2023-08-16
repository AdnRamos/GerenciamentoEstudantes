package br.edu.ufape.poo.gerenciamentoestudantes.dados;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoProjeto;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Projeto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InterfaceColecaoProjetoTeste {
    @Autowired
    private InterfaceColecaoProjeto ColecaoProjeto;
    @Test
    void cadastrarProjetoTeste(){
        long qtdProjetos = ColecaoProjeto.count();
        Projeto pro = new Projeto("Test", "faz alguma cosia", "11/02/2022","java", "saude", "clienteServidor");
        ColecaoProjeto.save(pro);
        long qtdProjetos1 = ColecaoProjeto.count();
        assertEquals(qtdProjetos+1, qtdProjetos1);
    }
}
