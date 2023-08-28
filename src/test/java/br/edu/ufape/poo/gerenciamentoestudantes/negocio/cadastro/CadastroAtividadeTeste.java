package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.RegistroAtividade;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.RegistroAtividadeDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CadastroAtividadeTeste {
    @Autowired
    private CadastroAtividade cadastroAtividade;
    @Autowired
    private CadastroEstudante cadastroEstudante;

    @Test
    public void salvarRegistroAtividadeTeste() throws RegistroAtividadeDuplicadoException {
        // Criar um registro de atividade para teste
        RegistroAtividade registroAtividade = new RegistroAtividade();
        registroAtividade.setDescricao("Atividade de Teste");

        // Cadastrar o registro de atividade
        RegistroAtividade resultado = cadastroAtividade.salvarRegistroAtividade(registroAtividade);

        // Verificar se o registro foi cadastrado com sucesso
        assertNotNull(resultado.getId());
        assertEquals("Atividade de Teste", resultado.getDescricao());

        // Buscar o registro cadastrado
        RegistroAtividade registroCadastrado = cadastroAtividade.buscarRegistroAtividadePorId(resultado.getId());
        assertNotNull(registroCadastrado);
        assertEquals(resultado.getId(), registroCadastrado.getId());
    }
    @Test
    public void cadastrarRegistroAtividadeDuplicadoTeste() throws RegistroAtividadeDuplicadoException {
        // Criar um registro de atividade para teste
        RegistroAtividade registroAtividade = new RegistroAtividade("O que ta acontecendo aqui");

        // Tentar cadastrar o mesmo registro novamente deve lançar a exceção RegistroAtividadeDuplicadoException
        assertThrows(RegistroAtividadeDuplicadoException.class, () -> {
            cadastroAtividade.salvarRegistroAtividade(registroAtividade);
        });
    }
    //Teste de Integração
    @Test
    public void CadastroRegistroAtividadeComEstudanteTeste() throws UsuarioDuplicadoException {
        //criando estudante
        Estudante estudante = new Estudante("werqwerqwerqw");
        cadastroEstudante.salvarEstudante(estudante);
        //criando atividade
        RegistroAtividade registroAtividade = new RegistroAtividade("qwerqwerqwerqwer 1");
        registroAtividade.setEstudante(estudante);
        cadastroAtividade.salvarRegistroAtividade(registroAtividade);

        assertNotNull(registroAtividade.getId());//verifica se  atividade foi registrada
        assertEquals(estudante, registroAtividade.getEstudante());//verifica se o estudante foi vinculado a atividade
    }

}
