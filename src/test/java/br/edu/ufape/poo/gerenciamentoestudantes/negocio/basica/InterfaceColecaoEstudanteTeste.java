package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoEstudante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InterfaceColecaoEstudanteTeste {
    @Autowired
    private InterfaceColecaoEstudante ColecaoEstudante;
    @Test
    void cadastrarTest(){
        //inicialização OBS:Acho que deva ta certo
        long qtdEstudante = ColecaoEstudante.count();
        Endereco endereco = new Endereco("qd 3",152,"garanhuns","PE","55345000");
        Estudante e = new Estudante(true, "Carlos", "carlosKraio@gmail.com", "bcc","8799811155","88855588","sds","30/10/98","123456785","solteiro","brasileiro","garanhuns","321515351");
        e.setEndereco(endereco);

        //Interacao
        ColecaoEstudante.save(e);
        long qtdEstudantes1 = ColecaoEstudante.count();
        //Verificacao
        assertEquals(qtdEstudante+1, qtdEstudantes1);
    }


}
