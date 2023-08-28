package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.RegistroAtividade;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.RegistroAtividadeDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CadastroAtividadeTest {
    @Autowired
    private CadastroAtividade cadastroAtividade;
    @Autowired
    private CadastroEstudante cadastroEstudante;

    @Test
    public void salvarRegistroAtividadeTeste() throws RegistroAtividadeDuplicadoException {
        // Criar um registro de atividade para teste
        RegistroAtividade registroAtividade = new RegistroAtividade();
        registroAtividade.setDescricao("Atividade de qwerqwevavadvXdzdxf");

        // Cadastrar o registro de atividade
        RegistroAtividade resultado = cadastroAtividade.salvarRegistroAtividade(registroAtividade);

        // Verificar se o registro foi cadastrado com sucesso
        assertNotNull(resultado.getId());
        assertEquals("Atividade de qwerqwevavadvXdzdxf", resultado.getDescricao());

        // Buscar o registro cadastrado
        RegistroAtividade registroCadastrado = cadastroAtividade.buscarRegistroAtividadePorId(resultado.getId());
        assertNotNull(registroCadastrado);
        assertEquals(resultado.getId(), registroCadastrado.getId());
    }
    @Test
    public void cadastrarRegistroAtividadeDuplicadoTeste() throws RegistroAtividadeDuplicadoException, UsuarioDuplicadoException {
        // Criar um registro de atividade para teste
        RegistroAtividade atividadeDuplicada = new RegistroAtividade("O que ta acontecendo aqui");
        Estudante estudante = new Estudante();
        cadastroEstudante.salvarEstudante(estudante);

        atividadeDuplicada.setEstudante(estudante);
        // Tentar cadastrar o mesmo registro duas vezes deve lançar a exceção RegistroAtividadeDuplicadoException
        cadastroAtividade.salvarRegistroAtividade(atividadeDuplicada);

        assertThrows(RegistroAtividadeDuplicadoException.class, () -> {
            cadastroAtividade.salvarRegistroAtividade(atividadeDuplicada);
        });
    }
    //Teste de Integração
    @Test
    public void CadastroRegistroAtividadeComEstudanteTeste() throws UsuarioDuplicadoException {
        //criando estudante
        Estudante estudante = new Estudante("werqwerqwerqw");
        estudante.setEmail("dfjapsdfpadsfpasm");
        cadastroEstudante.salvarEstudante(estudante);
        //criando atividade
        RegistroAtividade registroAtividade = new RegistroAtividade("qwerqwerqwerqwer 1");
        registroAtividade.setEstudante(estudante);
        cadastroAtividade.salvarRegistroAtividade(registroAtividade);

        assertNotNull(registroAtividade.getId());//verifica se  atividade foi registrada
        assertEquals(estudante, registroAtividade.getEstudante());//verifica se o estudante foi vinculado a atividade
    }

}
