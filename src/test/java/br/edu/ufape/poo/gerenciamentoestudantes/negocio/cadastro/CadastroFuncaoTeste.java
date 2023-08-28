package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.TipoFuncao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Funcao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.CadastroEstudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.CadastroFuncao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.FuncaoDuplicadaException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.FuncaoNaoEncontradaException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CadastroFuncaoTeste {

    @Autowired
    private CadastroFuncao cadastroFuncao;

    @Autowired
    private CadastroEstudante cadastroEstudante;

    @Test
    public void testCadastrarFuncao() throws UsuarioDuplicadoException {
        Estudante estudante = new Estudante(true, "jose", "aosidjfoaijsdofjasodjfoia", "5544552");
        cadastroEstudante.salvarEstudante(estudante); // Persiste o estudante

        Funcao funcao = new Funcao(TipoFuncao.BACK_END, "01/01/2023");
        funcao.setEstudante(estudante);

        Funcao cadastrada = cadastroFuncao.cadastrarFuncao(estudante, funcao);

        assertNotNull(cadastrada);
        assertNotNull(cadastrada.getId());
        assertEquals(funcao.getTipoFuncao(), cadastrada.getTipoFuncao());
    }

    @Test
    public void testCadastrarFuncaoDuplicada() throws UsuarioDuplicadoException {
        Estudante estudante = new Estudante(true, "jose", "asdfasdfasdfa", "5544552");
        cadastroEstudante.salvarEstudante(estudante); // Persiste o estudante

        Funcao funcao = new Funcao(TipoFuncao.FRONT_END, "01/01/2023");
        cadastroFuncao.cadastrarFuncao(estudante, funcao);

        assertThrows(FuncaoDuplicadaException.class, () -> cadastroFuncao.cadastrarFuncao(estudante, funcao));
    }

    @Test
    public void testBuscarFuncaoPorId() throws UsuarioDuplicadoException {
        Estudante estudante = new Estudante(true, "jose", "2342342342", "5544552");
        cadastroEstudante.salvarEstudante(estudante); // Persiste o estudante

        Funcao funcao = new Funcao(TipoFuncao.FRONT_END, "01/01/2023");
        Funcao cadastrada = cadastroFuncao.cadastrarFuncao(estudante, funcao);

        Funcao encontrada = cadastroFuncao.buscarFuncaoPorId(cadastrada.getId());

        assertNotNull(encontrada);
        assertEquals(cadastrada.getId(), encontrada.getId());
    }

    @Test
    public void testBuscarFuncaoPorIdNaoEncontrada() {
        assertThrows(FuncaoNaoEncontradaException.class, () -> cadastroFuncao.buscarFuncaoPorId(9999L));
    }

}
