package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.TipoFuncao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Funcao;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.FuncaoDuplicadaException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.FuncaoNaoEncontradaException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CadastroFuncaoTest {

    @Autowired
    private CadastroFuncao cadastroFuncao;

    @Autowired
    private CadastroEstudante cadastroEstudante;

    @Test
    public void CadastrarFuncaoTeste() throws UsuarioDuplicadoException {
        Estudante estudante = new Estudante(true, "jose", "aosidjfoaijsdofjasodjfoia", "5544552");

        Funcao funcao = new Funcao(TipoFuncao.BACK_END, "01/01/2023");
        funcao.setEstudante(estudante);

        Funcao cadastrada = cadastroFuncao.cadastrarFuncao(funcao);

        assertNotNull(cadastrada);
        assertEquals(funcao.getTipoFuncao(), cadastrada.getTipoFuncao());
    }

    @Test
    public void CadastrarFuncaoDuplicadaTeste() throws UsuarioDuplicadoException {
        Estudante estudante = new Estudante(true, "jose", "asdfasdfasdfa", "5544552");
        cadastroEstudante.salvarEstudante(estudante); // Persiste o estudante

        Funcao funcao = new Funcao(TipoFuncao.FRONT_END, "01/01/2023");
        funcao.setEstudante(estudante);
        cadastroFuncao.cadastrarFuncao(funcao);

        assertThrows(FuncaoDuplicadaException.class, () -> cadastroFuncao.cadastrarFuncao(funcao));
    }

    @Test
    public void BuscarFuncaoPorIdTeste() throws UsuarioDuplicadoException {
        Estudante estudante = new Estudante(true, "jose", "2342342342", "5544552");
        cadastroEstudante.salvarEstudante(estudante); // Persiste o estudante

        Funcao funcao = new Funcao(TipoFuncao.FRONT_END, "01/01/2023");
        funcao.setEstudante(estudante);
        Funcao cadastrada = cadastroFuncao.cadastrarFuncao(funcao);

        Funcao encontrada = cadastroFuncao.buscarFuncaoPorId(cadastrada.getId());

        assertNotNull(encontrada);
        assertEquals(cadastrada.getId(), encontrada.getId());
    }

    @Test
    public void BuscarFuncaoPorIdNaoEncontradaTeste() {
        assertThrows(FuncaoNaoEncontradaException.class, () -> cadastroFuncao.buscarFuncaoPorId(9999L));
    }

}
