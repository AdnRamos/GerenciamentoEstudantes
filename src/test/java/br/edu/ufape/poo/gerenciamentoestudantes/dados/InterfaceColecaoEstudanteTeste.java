package br.edu.ufape.poo.gerenciamentoestudantes.dados;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.*;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.DiaSemana;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.ModalidadeAtividade;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.TipoFuncao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.TipoVinculo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InterfaceColecaoEstudanteTeste{
    @Autowired
    private InterfaceColecaoEstudante ColecaoEstudante;
    private List<Vinculo> vinculos;
    private List<Funcao> funcoes;
    private List<Participacao> participacoes;
    private List<Projeto> projetos;

    @Test
    void cadastrarEstudanteTest(){
        //inicialização OBS:Acho que deva ta certo
        long qtdEstudante = ColecaoEstudante.count();
        //Teste base criação estudante herdando a classe pessoa
        Estudante e = new Estudante(true, "Carlos", "carlossampaio@gmail.com",
                "bcc","8799811155","88855588","sds",
                "30/10/98","123456785","solteiro","brasileiro",
                "garanhuns","321515351");
        //Integrando com endereço
        Endereco endereco = new Endereco("qd 3",152,"garanhuns","PE","55345000");
        e.setEndereco(endereco);
        //Integracao com vinculo
        vinculos = new ArrayList<Vinculo>();
        e.setVinculos(vinculos);
        Vinculo vinc = new Vinculo(TipoVinculo.VOLUNTARIO,"10:00", "20/15/2021");
        e.addVinculo(vinc);
        //Integracao com funcao
        funcoes = new ArrayList<>(5);
        e.setFuncoes(funcoes);
        Funcao func = new Funcao(TipoFuncao.SCRUM_MASTER,"12/08/2000");
        e.addFuncao(func);
        //Integracao participacao
        projetos = new ArrayList<Projeto>();
        Projeto projeto = new Projeto("ten","que matar um","15/02/2022","java", "agro","clienteServidor");
        participacoes = new ArrayList<>(5);
        e.setParticipacoes(participacoes);
        Participacao part = new Participacao("12/02/2022");
        part.setEstudante(e);
        part.setProjeto(projeto);
        e.addParticipacao(part);
        //salvando bolsa
        Bolsa b =  new Bolsa("se fudeo", "vai ganhar money", "12/12/22", "15/01/23");

        //salvando na colecao
        ColecaoEstudante.save(e);
        long qtdEstudantes1 = ColecaoEstudante.count();
        //verificando o cadastro
        assertEquals(qtdEstudante+1, qtdEstudantes1);
    }
}
