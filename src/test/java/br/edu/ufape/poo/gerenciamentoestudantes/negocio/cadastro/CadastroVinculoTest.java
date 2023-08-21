package br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Enums.TipoVinculo;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Estudante;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.Vinculo;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioDuplicadoException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.UsuarioNaoExisteException;
import br.edu.ufape.poo.gerenciamentoestudantes.negocio.cadastro.exception.VinculoDuplicadoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CadastroVinculoTest {

    @Autowired
    private InterfaceCadastroVinculo cadastroVinculo;
    @Autowired
    private InterfaceCadastroEstudante cadastroEstudante;


    @BeforeEach
    public void setUp() throws UsuarioDuplicadoException {

    }

    @Test
    public void testSalvarVinculo() throws VinculoDuplicadoException, UsuarioNaoExisteException, UsuarioDuplicadoException {
        // Instanciar o vinculo
        Vinculo vinculo = new Vinculo();
        vinculo.setTipoVinculo(TipoVinculo.BOLSISTA);
        vinculo.setQtdHorasSemanais("10");
        vinculo.setDataInicio(LocalDate.now().toString());

        // Criar o estudante
        String email = "teste@teste.com";
        Estudante e0 = new Estudante(true, "Nome do Estudante", email, "5544552");
        cadastroEstudante.salvarEstudante(e0);

        // Consultar o estudante pelo mesmo e-mail usado para criar
        Estudante estudante = cadastroEstudante.consultarEstudantePorEmail(email);

        // Salvar vínculo no cadastro
        Vinculo vinculoSalvo = cadastroVinculo.cadastrarVinculo(estudante, vinculo);

        // Verifica se o vínculo foi salvo corretamente
        assertNotNull(vinculoSalvo);
        assertNotNull(vinculoSalvo.getId()); // Verifica se o ID foi gerado
    }
}
