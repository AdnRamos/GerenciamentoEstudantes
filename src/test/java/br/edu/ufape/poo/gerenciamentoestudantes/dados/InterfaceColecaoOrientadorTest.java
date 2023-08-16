package br.edu.ufape.poo.gerenciamentoestudantes.dados;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoOrientador;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Endereco;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Orientador;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InterfaceColecaoOrientadorTest {
    @Autowired
    private InterfaceColecaoOrientador colecaoOrientador;

    @Test
    void cadastrarOrientadorTeste(){
        long qtdOrientador = colecaoOrientador.count();

        //Teste base criação estudante herdando a classe pessoa
        Orientador o = new Orientador(true,"joao","joaocarlos@ufape","Pedago", "9999999999999", "888.588.82", "SDS", "30/02/25","99966665555","casado","brasileiro","São Jose","mobile");
        //Integrando com endereço
        Endereco endereco = new Endereco("qd 3",152,"garanhuns","PE","55345000");
        o.setEndereco(endereco);
        colecaoOrientador.save(o);
        long qtdOrientador1 = colecaoOrientador.count();
        assertEquals(qtdOrientador+1,qtdOrientador1);
    }

}
