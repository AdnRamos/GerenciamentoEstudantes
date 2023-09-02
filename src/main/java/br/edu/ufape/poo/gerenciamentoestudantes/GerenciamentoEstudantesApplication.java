package br.edu.ufape.poo.gerenciamentoestudantes;

import br.edu.ufape.poo.gerenciamentoestudantes.negocio.basica.serializacao.JacksonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(JacksonConfig.class)
public class GerenciamentoEstudantesApplication {

    public static void main(String[] args) {
        SpringApplication.run(GerenciamentoEstudantesApplication.class, args);
    }



}
