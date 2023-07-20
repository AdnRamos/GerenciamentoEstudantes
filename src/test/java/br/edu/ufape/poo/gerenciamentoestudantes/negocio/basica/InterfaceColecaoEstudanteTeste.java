package br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica;

import br.edu.ufape.poo.gerenciamentoestudantes.dados.InterfaceColecaoEstudante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InterfaceColecaoEstudanteTeste {
    @Autowired
    private InterfaceColecaoEstudante ColecaoEstudante;
    private ArrayList<Horario> horarios;
    private ArrayList<RegistroAtividade> registros;

    @Test
    void cadastrarEstudanteTest(){
        //inicialização OBS:Acho que deva ta certo
        long qtdEstudante = ColecaoEstudante.count();
        //Teste base criação estudante herdando a classe pessoa
        Estudante e = new Estudante(true, "Carlos", "carlosKraio@gmail.com", "bcc","8799811155","88855588","sds","30/10/98","123456785","solteiro","brasileiro","garanhuns","321515351");
        //Integrando com endereço
        Endereco endereco = new Endereco("qd 3",152,"garanhuns","PE","55345000");
        e.setEndereco(endereco);
        //Integrando com horaios
        Horario h1 = new Horario(ModalidadeAtividade.PRESENCIAL, DiaSemana.SEGUNDA,"14:00", "17:00");
        Horario h2 = new Horario(ModalidadeAtividade.REMOTO, DiaSemana.QUARTA,"14:00", "17:00");
        //Iniciando o ArrayList
        horarios = new ArrayList<>(5);
        e.setHorarios(horarios);
        //adicionando os horarios no ArrayList
        e.addHorario(h1);
        e.addHorario(h2);
        //Integrando com geristro de atividades
        RegistroAtividade reg = new RegistroAtividade("fiz nada nessa desgraca nao");
        //Iniciando o ArrayList
        reg.setHorario(h1);
        registros = new ArrayList<>(5);
        e.setRegistros(registros);
        //Adicionando o registro
        e.addRegistro(reg);

        //salvando na colecao
        ColecaoEstudante.save(e);
        long qtdEstudantes1 = ColecaoEstudante.count();
        //verificando o cadastro
        assertEquals(qtdEstudante+1, qtdEstudantes1);
    }
}
